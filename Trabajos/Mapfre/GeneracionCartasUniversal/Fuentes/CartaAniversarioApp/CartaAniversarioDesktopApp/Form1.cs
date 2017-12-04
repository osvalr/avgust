using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using CartaAniversarioBusinessApp.util;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            GetTextDocxUtil obj = new GetTextDocxUtil();
            //obj.process(textBox2.Text,"c:\\users\\jraffo_w7_app\\documents\\visual studio 2010\\Projects\\CartaAniversarioApp\\CartaAniversarioDesktopApp\\resources\\properties.json","c:\\users\\jraffo_w7_app\\documents\\visual studio 2010\\Projects\\CartaAniversarioApp\\CartaAniversarioDesktopApp\\resources\\textLabels.json");
            //textBox1.Text = textResult;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox2.Text = "C:\\Mapfre\\Cartas Modelo\\Cartas Modelo\\2015 Marzo\\2015 Marzo\\21.03.2015.docx";
        }
    }
}
