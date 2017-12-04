package proyecto.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import com.sun.xml.internal.bind.v2.runtime.property.Property;

import proyecto.vo.FichaRegistro;

/**
 * Clase donde se implementa el escuchador definido en web.xml El listener se
 * ejecutar� al arrancar la aplicaci�n. Su funcionamiento ser� definir una tarea
 * en Quartz y lanzar el trigger con los par�metros que interesen (en este caso
 * un retardo de 60 segundos).
 * 
 * @author gonzalo.delgado
 * 
 */
public class QuartzListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ResourceBundle rb = null;
		try {
			// Obtenemos las Fechas de los Formularios por aprobar
			Collection<FichaRegistro> c = new ArrayList<FichaRegistro>();
			c  = this.listaFechasJob();
			
			if (c.size() > 0) {
			
				for (FichaRegistro t : c) {
										
					// obtener las fecha en cantidad de milisegundos de tipo
					// cadena
					String sfecha = t.getFechaaprobsys().getTime() + "" + t.getIdficharegistro();

					// Definimos un trabajo					
					JobDetail jobd = newJob(QuartzJobInicio.class).withIdentity(
							"job" + sfecha, "group" + sfecha).build();

					jobd.getJobDataMap().put("ficharegistro", t);
					jobd.getJobDataMap().put("areanatural", t.getAreanatural());
										
					rb = ResourceBundle.getBundle("proyecto.quartz.Quartz");
					
					jobd.getJobDataMap().put("DirectorioJasper", rb.getString("ruta.jasper"));
					jobd.getJobDataMap().put("DirectorioDescargaFicha", rb.getString("ruta.descarga.ficha"));
					
					
					System.out.println("Definido el Job en el listener "
							+ new Date().toString());

					Date fecha_ejec = new Date(t.getFechaaprobsys().getTime());
					SimpleTrigger trigger = (SimpleTrigger) newTrigger()
							.withIdentity("trigger" + sfecha, "group" + sfecha)
							.startAt(fecha_ejec)
							.forJob("job" + sfecha, "group" + sfecha).build();

					// Instanciamos el gestor de tareas, a trav�s de la clase
					// SchedulerFactory
					SchedulerFactory schedfact=new StdSchedulerFactory();
					Scheduler sched=schedfact.getScheduler();
					
					// Arrancamos el gestor de tareas.
					sched.start();
					
					sched.scheduleJob(jobd, trigger);
				}
			}

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

	public Collection<FichaRegistro> listaFechasJob() {

		Collection<FichaRegistro> c = new ArrayList<FichaRegistro>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String query = "SELECT fr.* "
				+ "FROM sernanp.ficharegistro fr WHERE idestadoficha = ? "
				+ "ORDER BY fechaaprobsys ASC";

		try {
			con = QuartzConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, 1);

			rs = stmt.executeQuery();
			while (rs.next()) {
				FichaRegistro vo = new FichaRegistro();
				vo.setIdficharegistro(rs.getInt("idficharegistro"));
				vo.getAreanatural().setIdareanatural(rs.getInt("idareanatural"));
				vo.getOperadorturismo().setIdpersonajuridica(rs.getInt("idpersonajuridica"));
				vo.setFechaaprobsys(rs.getTimestamp("fechaaprobsys"));
				
				c.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		return c;

	}
}