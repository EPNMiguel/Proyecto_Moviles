package ec.edu.epn.modelo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import ec.edu.epn.modelo.entity.Juego;

@Path("SrvJuego")
public class ServicioJuego extends Application {

	@GET
	@Path("prueba")
	public String prueba (@QueryParam("texto")String texto) {
		return "prueba jodidamente exitosa:" + texto;
	}

	@GET
	@Path("ingresarJuego")
	public String ingresarJuego(
			@QueryParam("titulo")String titulo,
			@QueryParam("descripcion")String descripcion,
			@QueryParam("categoria")String categoria,
			@QueryParam("plataforma")String plataforma,
			@QueryParam("nombre_imagen")String nombre_imagen){
		System.out.println(titulo);
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS","epnmov","epnmov");
			PreparedStatement ps = con.prepareStatement("insert into juego (titulo,descripcion,categoria,plataforma,nombre_imagen)values(?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, descripcion);
			ps.setString(3, categoria);
			ps.setString(4, plataforma);
			ps.setString(5, nombre_imagen);
			ps.execute();//retorna los registros afectados
			ps.close();
			con.close();
			return "Juego ingresado exitosamente";

		}catch(Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			return "Error al ingresar el juego <br>"+e;
		}

	}

	@GET
	@Path("mostraJuego")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Juego> mostrarJuego(){
		List<Juego> lj = new ArrayList<Juego>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS","epnmov","epnmov");
			PreparedStatement ps = con.prepareStatement("select * from juego ");
			ResultSet rs= ps.executeQuery();

			while(rs.next()){
				Juego j = new Juego();
				j.setTitulo(rs.getString("titulo"));
				j.setDescripcion(rs.getString("descripcion"));
				j.setCategoria(rs.getString("categoria"));
				j.setPlataforma(rs.getString("plataforma"));
				j.setNombre_imagen(rs.getString("nombre_imagen"));
				lj.add(j);
				//System.out.println(j.getTitulo()+":"+j.getCategoria());
			}
			ps.close();
			con.close();
			return lj;
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return lj;

	}
	@PUT
	@Path("editarJuego")
	public void editarJuego(){

	}
	@DELETE
	@Path("eliminarJuego")
	public void eliminarJuego(){

	}

}

