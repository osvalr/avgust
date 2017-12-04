using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FatcaDesktopApp.util
{
    public class ReadProperties
    {
        public static Dictionary<string, string> read(String pathFile)
        {

            var data = new Dictionary<string, string>();
            foreach (var row in File.ReadAllLines(pathFile))
            {
                data.Add(row.Split('=')[0], string.Join("=", row.Split('=').Skip(1).ToArray()));
            }

            return data;

        }
    }
}
