using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CartaAniversarioBusinessApp.model
{
    public class CartaCab
    {
        public System.DateTime fechaFinaliza {get;set;}
        public String numeroPoliza { get; set; }

        public System.DateTime fechaDesde { get; set; }
        public System.DateTime fechaHasta { get; set; }
        public System.DateTime fechaEfectiva { get; set; }
        public Double beneficioMuerteBasico1 { get; set; }
        public Double beneficioMuerteBasico2 { get; set; }
        public String asegurado { get; set; }
        public String agente { get; set; }
        public String contratante { get; set; }
        public String DireccionContratante { get; set; }
        public String localidadContratante { get; set; }

        public Double valorEfectivoAcumulado1 { get; set; }
        public Double valorEfectivoAcumulado2 { get; set; }

        public Double balancePrestamo1 { get; set; }
        public Double balancePrestamo2 { get; set; }

        public Double cargosRescate1 { get; set; }
        public Double cargosRescate2 { get; set; }

        public Double valorEfectivoCorriente1 { get; set; }
        public Double valorEfectivoCorriente2 { get; set; }

        public int estado { get; set; }

        public List<CartaDet> listCartaDet { get; set; } 
    }
}
