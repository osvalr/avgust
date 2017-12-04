using System;
using System.IO;
using System.Text;
using System.Xml;
using ICSharpCode.SharpZipLib.Zip;
using System.Collections.Generic;
using System.Web.Script.Serialization;
using System.Reflection;
using System.Globalization;

namespace CartaAniversarioBusinessApp.util
{
    public class GetTextDocxUtil
    {

        private const int TIPO_TEXTO_OTRO = 1;
        private const int TIPO_TEXTO_ETIQUETA = 2;

        /// <summary>
        private const int TIPO_DATO_INT = 1;
        private const int TIPO_DATO_DOUBLE = 2;
        private const int TIPO_DATO_CADENA = 3;
        private const int TIPO_DATO_FECHA = 4;

        private const int TIPO_PROPIEDAD_CABECERA = 1;
        private const int TIPO_PROPIEDAD_DETALLE = 2;
        /// </summary>

        private string file = "";
        private string location = "";

        private List<model.Property> listProperties;
        private List<model.TextLabel> listTextLabels;

        // constructor, with the fileName you want to extract the text from
        public GetTextDocxUtil(string theFile) { file = theFile; }
        public GetTextDocxUtil() { }

        // Here the do it all method, call it after the constructor
        // it will try to find and parse document.xml from the zipped file
        // and return the docx's text in a string
        public string getDocumentText()
        {

            if (string.IsNullOrEmpty(file))
            {
                throw new Exception("No Input file");
            }

            location = getDocumentXmlFile_FromZipFile();

            if (string.IsNullOrEmpty(location))
            {
                throw new Exception("Invalid Docx");
            }

            return ReadDocumentText();
        }

        // we go to the xml file location
        // load it
        // and return the extracted text
        private string ReadDocumentText()
        {
            StringBuilder result = new StringBuilder();

            string bodyXPath = "/w:document/w:body";

            ZipFile zipped = new ZipFile(file);
            foreach (ZipEntry entry in zipped)
            {
                if (string.Compare(entry.Name, location, true) == 0)
                {
                    XmlDocument xmlDoc = new XmlDocument();
                    xmlDoc.PreserveWhitespace = true;
                    xmlDoc.Load(zipped.GetInputStream(entry));

                    XmlNamespaceManager xnm = new XmlNamespaceManager(xmlDoc.NameTable);
                    xnm.AddNamespace("w", @"http://schemas.openxmlformats.org/wordprocessingml/2006/main");

                    XmlNode node = xmlDoc.DocumentElement.SelectSingleNode(bodyXPath, xnm);

                    if (node == null) { return ""; }
                    result.Append(ReadNode(node));
                    break;
                }
            }
            zipped.Close();

            return result.ToString();
        }

        // Xml node reader helper :D
        private string ReadNode(XmlNode node)
        {
            // not a good node ?
            if (node == null || node.NodeType != XmlNodeType.Element) { return ""; }

            StringBuilder result = new StringBuilder();
            foreach (XmlNode child in node.ChildNodes)
            {
                // not an element node ?
                if (child.NodeType != XmlNodeType.Element) { continue; }

                // lets get the text, or replace the tags for the actua text's characters
                switch (child.LocalName)
                {
                    case "tab": result.Append("\t"); break;
                    case "p": result.Append(ReadNode(child)); result.Append("\r\n\r\n"); break;
                    case "cr":
                    case "br": result.Append("\r\n"); break;

                    case "t": // its Text !
                        result.Append(child.InnerText.TrimEnd());
                        string space = ((XmlElement)child).GetAttribute("xml:space");
                        if (!string.IsNullOrEmpty(space) && space == "preserve") { result.Append(' '); }
                        break;

                    default: result.Append(ReadNode(child)); break;
                }
            }

            return result.ToString();
        }

        // lets open the zip file and look up for the
        // document.xml file
        // and save its zip location into the location variable
        private string getDocumentXmlFile_FromZipFile()
        {
            // ICsharpCode helps here to open the zipped file
            ZipFile zip = new ZipFile(file);

            // lets take a look to the file entries inside the zip file
            // up to we get
            foreach (ZipEntry entry in zip)
            {

                if (string.Compare(entry.Name, "[Content_Types].xml", true) == 0)
                {
                    Stream contentTypes = zip.GetInputStream(entry);

                    XmlDocument xmlDoc = new XmlDocument();
                    xmlDoc.PreserveWhitespace = true;
                    xmlDoc.Load(contentTypes);

                    contentTypes.Close();

                    // we need a XmlNamespaceManager for resolving namespaces
                    XmlNamespaceManager xnm = new XmlNamespaceManager(xmlDoc.NameTable);
                    xnm.AddNamespace("t", @"http://schemas.openxmlformats.org/package/2006/content-types");

                    // lets find the location of document.xml
                    XmlNode node = xmlDoc.DocumentElement.SelectSingleNode("/t:Types/t:Override[@ContentType=\"application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml\"]", xnm);

                    if (node != null)
                    {
                        string location = ((XmlElement)node).GetAttribute("PartName");
                        return location.TrimStart(new char[] { '/' });
                    }
                    break;
                }
            }

            // close the zip
            zip.Close();

            return null;
        }

        public void writeTextFile(string pathFile, string contentFile) {
            StreamWriter writetext = new StreamWriter(pathFile);
            writetext.WriteLine(contentFile);
            writetext.Close();
        }

        public String cleanTextFromTabsSpaces(string text) {

            string t = text.TrimStart().TrimEnd();
            String taux = "";
            List<String> tabs = new List<String>();
            List<String> spaces = new List<String>();

            for (int i = 0; i < 50; i++)
            {
                taux = taux + "\t";
                tabs.Add(taux);
            }

            taux = "".PadLeft(1);

            for (int i = 0; i < 50; i++)
            {
                taux = taux + "".PadLeft(1);
                spaces.Add(taux);
            }

            foreach (String x in tabs)
            {
                t = t.Replace(x, "".PadLeft(1));
            }

            foreach (String x in spaces)
            {
                t = t.Replace(x, "".PadLeft(1));
            }

            return t;
        }

        public String removeText(String t) {

            foreach (model.TextLabel x in listTextLabels)
            {
                //if (x.type == TIPO_TEXTO_OTRO)
                //{
                //    t = t.Replace(x.text, String.Empty);
                //}
            }

            return t;

        }

        public String removeTags(String t)
        {

            foreach (model.TextLabel x in listTextLabels)
            {

                    t = t.Replace(x.text, "|");
                
            }

            return t;

        }

        public void decodeJson(String pathProperties, String pathTextLabel)
        {
            string properties = System.IO.File.ReadAllText(@pathProperties);
            string labels = System.IO.File.ReadAllText(@pathTextLabel);

            listProperties = new JavaScriptSerializer().Deserialize<List<model.Property>>(properties);
            listTextLabels = new JavaScriptSerializer().Deserialize<List<model.TextLabel>>(labels);
        }

        public model.Property findPropertyByIndexAndType(int index, int type)
        {
            foreach (model.Property x in listProperties)
            {
                if (x.index == index && x.typeProperty == type)
                {
                    return x;
                }
            }
            return null;
        }

        public List<model.CartaCab> process(String path, List<model.Property> properties, List<model.TextLabel> textLabels) 
        {

            this.file = path;

            //this.decodeJson(pathProperties,pathTextLabel);
            this.listProperties = properties;
            this.listTextLabels = textLabels;

            List<model.CartaCab> listCartCab = new List<model.CartaCab>();
            List<List<model.CartaDet>> listDetail = new List<List<model.CartaDet>>();
            List<model.CartaDet> listCartaDet = new List<model.CartaDet>();
            bool checkNew = false;

            String text = "";
            String textAcumulado = "";

            //Limpiamos el documento de los espacios y tabulaciones que esten demas.
            string[] linesz = this.getDocumentText().Split('\n');
            for (int i = 0; i < linesz.Length; i++)
            {
                if (linesz[i].TrimStart().TrimEnd() != string.Empty)
                {
                    string t = this.cleanTextFromTabsSpaces(linesz[i]);
                    text = text + t + "\n";
                }
            }

            //Removemos los texto que no son tomados encuenta.
            //text = this.removeText(text);
            //Removemos y marcamos las etiquedas donde hay valores a capturar.
            text = this.removeTags(text);

            //this.writeTextFile("C:\\Mapfre\\Cartas Modelo\\Cartas Modelo\\2015 Marzo\\2015 Marzo\\write.txt", text.Trim());

            string[] linesx = text.Trim().Split('\n');
            int k = 0;
            for (int j = 0; j < linesx.Length; j++)
            {
                int index = linesx[j].IndexOf("|");

                if (index != -1)
                {
                    string[] words = linesx[j].Split('|');
                    for (int i = 1; i < words.Length; i++)
                    {
                        string val = words[i].Trim();
                        if (val != string.Empty)
                        {
                            textAcumulado = textAcumulado + val + "\n";
                            if (k == 12)
                            {
                                textAcumulado = textAcumulado + "#\n";
                                k = -1;
                            }
                        }
                        k++;
                    }

                }
                else { 
                
                    ////
                    int posTotal = linesx[j].IndexOf("Totales");
                    bool isDetail = true;
                    string[] words = linesx[j].Split(' ');

                    if (posTotal <  0)
                    {
                        if (words.Length == 7)
                        {
                            for (int x = 0; x < words.Length; x++)
                            {
                                model.Property p = this.findPropertyByIndexAndType(x, TIPO_PROPIEDAD_DETALLE);
                                if (p != null)
                                {

                                    if (p.dataType == TIPO_DATO_DOUBLE)
                                    {
                                        try
                                        {
                                            double.Parse(words[x].Replace(",", String.Empty));
                                        }
                                        catch (Exception e)
                                        {
                                            isDetail = false;
                                        }
                                    }

                                    if (p.dataType == TIPO_DATO_FECHA)
                                    {
                                        try
                                        {
                                            DateTime.ParseExact(words[x], p.formatDate, CultureInfo.InvariantCulture);
                                        }
                                        catch (Exception e)
                                        {
                                            isDetail = false;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            isDetail = false;
                        }
                    }
                    else {
                        checkNew = true;
                        isDetail = false;
                        if (listCartaDet.Count > 0) {
                            listDetail.Add(listCartaDet);
                        }
                        
                    }

                    if (isDetail) {
                        
                        if (checkNew)
                        {
                            listCartaDet = new List<model.CartaDet>();
                            checkNew = false;
                        }

                        model.CartaDet cartaDet = new model.CartaDet();
                        for (int x = 0; x < words.Length; x++)
                        {
                            model.Property p = this.findPropertyByIndexAndType(x, TIPO_PROPIEDAD_DETALLE);
                            if (p != null)
                            {

                                if (p.dataType == TIPO_DATO_DOUBLE)
                                {
                                    PropertyInfo propertyInfo = cartaDet.GetType().GetProperty(p.name);
                                    string val = words[x].Replace(",", String.Empty);
                                    var fmt = new NumberFormatInfo();
                                    fmt.NegativeSign = "-";
                                    propertyInfo.SetValue(cartaDet, double.Parse(val,fmt), null);
                                }

                                if (p.dataType == TIPO_DATO_FECHA)
                                {
                                    PropertyInfo propertyInfo = cartaDet.GetType().GetProperty(p.name);

                                    DateTime dateTime = DateTime.ParseExact(words[x], p.formatDate, CultureInfo.InvariantCulture);

                                    propertyInfo.SetValue(cartaDet, dateTime, null);
                                }
                            }
                        }

                        listCartaDet.Add(cartaDet);
                    }
                    
                
                }
            }

            text = textAcumulado;

            

            string trama = "";
            string tramaAcumulado = "";
            string[] cab = text.Split('#');

            for (int i = 0; i < cab.Length; i++)
            {
                string[] lines = cab[i].Trim().Split('\n');
                for (int j = 0; j < lines.Length; j++)
                {

                    if (j == 4)
                    {

                        string[] arr = lines[j].Split(' ');
                        trama = trama + "|" + arr[0] + "|" + arr[1] + "|" + arr[2];

                    }
                    else if (j == 7 || j == 8 || j == 9 || j == 10)
                    {

                        string[] arr = lines[j].Split(' ');
                        trama = trama + "|" + arr[0] + "|" + arr[1];

                    }
                    else
                    {
                        if (trama == string.Empty)
                        {
                            trama = trama + lines[j];
                        }
                        else
                        {
                            trama = trama + "|" + lines[j];
                        }
                    }

                }

                {
                    
                    if (trama.Trim() != String.Empty) {
                        model.CartaCab cartaCab = new model.CartaCab();
                        string[] arr = trama.Split('|');
                        for (int q = 0; q < arr.Length; q++)
                        {
                            model.Property p = this.findPropertyByIndexAndType(q,TIPO_PROPIEDAD_CABECERA);

                            if (p != null)
                            {

                                if (p.dataType == TIPO_DATO_INT)
                                {
                                    PropertyInfo propertyInfo = cartaCab.GetType().GetProperty(p.name);
                                    var fmt = new NumberFormatInfo();
                                    fmt.NegativeSign = "-";
                                    propertyInfo.SetValue(cartaCab, int.Parse(arr[q].Replace(",", String.Empty),fmt), null);
                                }

                                if (p.dataType == TIPO_DATO_DOUBLE)
                                {
                                    PropertyInfo propertyInfo = cartaCab.GetType().GetProperty(p.name);
                                    var fmt = new NumberFormatInfo();
                                    fmt.NegativeSign = "-";
                                    propertyInfo.SetValue(cartaCab, double.Parse(arr[q].Replace(",", String.Empty),fmt), null);
                                }

                                if (p.dataType == TIPO_DATO_CADENA)
                                {
                                    PropertyInfo propertyInfo = cartaCab.GetType().GetProperty(p.name);
                                    propertyInfo.SetValue(cartaCab, arr[q], null);
                                }

                                if (p.dataType == TIPO_DATO_FECHA)
                                {
                                    PropertyInfo propertyInfo = cartaCab.GetType().GetProperty(p.name);

                                    DateTime dateTime = DateTime.ParseExact(arr[q], p.formatDate, CultureInfo.InvariantCulture);

                                    propertyInfo.SetValue(cartaCab, dateTime, null);
                                }

                            }

                        }
                        cartaCab.listCartaDet = listDetail[i];
                        listCartCab.Add(cartaCab);
                    }

                }

                tramaAcumulado = tramaAcumulado + trama + "\n";
                trama = "";
            }

            return listCartCab;
        }

        
    }

}

