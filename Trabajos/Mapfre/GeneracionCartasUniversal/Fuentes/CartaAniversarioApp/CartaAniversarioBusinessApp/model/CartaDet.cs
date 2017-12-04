using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CartaAniversarioBusinessApp.model
{
    public class CartaDet
    {
        public System.DateTime fechaAnterior { get; set; }
        public Double primaIngresada { get; set; }
        public Double cargoAdministrativo { get; set; }
        public Double costoSeguro { get; set; }
        public Double interesMonto { get; set; }
        public Double interesPorcentaje { get; set; }
        public Double rescateParcialPrestamo { get; set; }
    }
}
