using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CartaAniversarioBusinessApp;
using CartaAniversarioBusinessApp.model;
using CartaAniversarioBusinessApp.util;
using CartaAniversarioWebApp.util;
using System.Web.Script.Serialization;
using System.Web.Services;
using System.Web.Script.Services;
using System.Configuration;
using CartaAniversarioBusinessApp.repository;
using CartaAniversarioBusinessApp.model;
using System.Web.Script.Serialization;

namespace CartaAniversarioWebApp
{
    public partial class gestionarConfiguraciones : System.Web.UI.Page
    {

        public List<Property> listProperties = null;
        public List<TextLabel> listTextLabels = null;

        public string connStr = ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString;
        public CartaAniversarioRepository repo = new CartaAniversarioRepository();
        

        protected void Page_Load(object sender, EventArgs e)
        {
            string op = Request.QueryString["op"];

            if (op != null) {

                if (op == "listProperties") {
                    this.loadProperties();
                }

                if (op == "getProperty")
                {
                    int indexList = int.Parse(Request.QueryString["id"]);
                    this.getProperty(indexList);
                }

                if (op == "saveProperty")
                {
                    this.saveProperty();
                }
                
                //

                if (op == "listLabels")
                {
                    this.loadLabels();
                }

                if (op == "getLabel")
                {
                    int indexList = int.Parse(Request.QueryString["id"]);
                    this.getLabel(indexList);
                }

                if (op == "saveLabel")
                {
                    this.saveLabel();
                }

            }

        }

        public void loadProperties() {

            List<Property> list = repo.loadProperties(connStr);
            var jsonSerialiser = new JavaScriptSerializer();
            string properties = jsonSerialiser.Serialize(list);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(properties);
            Response.Flush();
            Response.End();

        }

        public void loadLabels()
        {

            List<TextLabel> list = repo.loadTextLabels(connStr,false);
            var jsonSerialiser = new JavaScriptSerializer();
            string labels = jsonSerialiser.Serialize(list);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(labels);
            Response.Flush();
            Response.End();

        }

        public void getProperty(int id)
        {

            List<Property> list = repo.loadProperties(connStr);

            Property property = this.findPropertyById(id, list);

            string json = new JavaScriptSerializer().Serialize(property);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(json);
            Response.Flush();
            Response.End();

        }

        public void getLabel(int id)
        {

            List<TextLabel> list = repo.loadTextLabels(connStr,false);

            TextLabel textLabel = this.findTextLabelById(id,list);

            string json = new JavaScriptSerializer().Serialize(textLabel);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(json);
            Response.Flush();
            Response.End();

        }

        public void saveProperty()
        {

            string response = "";

            int id = Int32.Parse(Request.QueryString["id"]);
            int index = Int32.Parse(Request.QueryString["index"]);
            string name = Request.QueryString["name"];
            int typeProperty = Int32.Parse(Request.QueryString["typeProperty"]);
            int dataType = Int32.Parse(Request.QueryString["dataType"]);
            string formatDate = Request.QueryString["formatDate"];

            Property property = new Property();

                property.index = index;
                property.name = name;
                property.typeProperty = typeProperty;
                property.dataType = dataType;
                property.formatDate = formatDate;
                property.nro_property = id;

                repo.updateProperty(property, connStr);

                response = "{\"success\":true}";

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(response);
            Response.Flush();
            Response.End();

        }

        public void saveLabel()
        {

            string response = "";

            int id = Int32.Parse(Request.QueryString["id"]);
            string text = Request.QueryString["text"];

            TextLabel textLabel = new TextLabel() ;

            textLabel.text = text;
            textLabel.nro_text_label = id;

            repo.updateTextLabel(textLabel, connStr);

            response = "{\"success\":true}";

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(response);
            Response.Flush();
            Response.End();

        }

        public Property findPropertyByName(string name, List<Property> listProperties)
        {
            foreach (Property x in listProperties)
            {
                if (x.name == name)
                {
                    return x;
                }
            }

            return null;
        }

        public int getIndexListPropertyByName(string name, List<Property> listProperties)
        {
            foreach (Property x in listProperties)
            {
                if (x.name == name)
                {
                    return listProperties.IndexOf(x);
                }
            }

            return -1;
        }

        public int countByName(string name, List<Property> listProperties)
        {
            int cant=0;
            foreach (Property x in listProperties)
            {
                if (x.name == name)
                {
                    cant++;
                }
            }

            return cant;
        }

        public Property findPropertyById(int id, List<Property> listProperties)
        {
            foreach (Property x in listProperties)
            {
                if (x.nro_property == id)
                {
                    return x;
                }
            }

            return null;
        }

        public TextLabel findTextLabelById(int id, List<TextLabel> list)
        {
            foreach (TextLabel x in list)
            {
                if (x.nro_text_label == id)
                {
                    return x;
                }
            }

            return null;
        }
    }
}