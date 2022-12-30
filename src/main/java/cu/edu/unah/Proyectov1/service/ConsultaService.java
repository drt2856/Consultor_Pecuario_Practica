package cu.edu.unah.Proyectov1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.auxiliar.Acumuladas;
import cu.edu.unah.Proyectov1.auxiliar.TardanzasRango;
import cu.edu.unah.Proyectov1.model.Minutos;
import cu.edu.unah.Proyectov1.model.Obreros;
import cu.edu.unah.Proyectov1.repository.MinutosRepository;
import cu.edu.unah.Proyectov1.repository.ObrerosRepository;


@Service
public class ConsultaService {

	@Autowired
	private ObrerosRepository obrerosRepository;
	private ObrerosService obrerosService;
	private MinutosRepository minutosRepository;
	

	public List<Obreros> consulta1() {
		Date dia =new Date();
		List<Obreros> obreros = obrerosRepository.findAll();
		List <Obreros> obrerosDevolver=new ArrayList<Obreros>();
		
		int dia_semana=dia.getDay();
		 
		int auxd=dia_semana;
		int cont =0;
		while (auxd!=0) {
			cont ++;
			auxd--;
		}
           Date domingo=new Date();
           domingo.setDate(domingo.getDate()-cont);
           Date sabado=new Date();
           sabado.setDate(domingo.getDate()+7);
           
           for (int i = 0; i < obreros.size(); i++) {
        	   Date cumple=new Date();
        	   cumple.setDate(obreros.get(i).getFechaDeNacimiento().getDate());
        	   cumple.setMonth(obreros.get(i).getFechaDeNacimiento().getMonth());


        	   if(cumple.compareTo(domingo)>=0) {
        		   if(cumple.compareTo(sabado)<=0) {
        			   obrerosDevolver.add(obreros.get(i));
        		   }
        	   }
        
           }
           
           obrerosDevolver= ordenarObreros(obrerosDevolver);
           
		return obrerosDevolver;
		
	}



	private List<Obreros> ordenarObreros(List<Obreros> obreros) {

		
		
		for (int i = 0; i < obreros.size()-1; i++) {
			for (int j = 0; j < obreros.size()-1; j++) {
				if(obreros.get(j).getAreaidArea().getIdArea()>obreros.get(j+1).getAreaidArea().getIdArea()) {
					Obreros x=obreros.get(j+1);
					obreros.set(j+1, obreros.get(j));
					obreros.set(j, x);
					
				}
			}
			
			}  
		return obreros;	
	
	}


	public List<TardanzasRango> consulta2(Date inicio, Date fin) {

		List<Minutos> minutos = minutosRepository.findAll();
		List<TardanzasRango> minutosDev = new ArrayList<TardanzasRango>();
		for (int i = 0; i < minutos.size(); i++) {
     	   Date diaTarde=minutos.get(i).getMinutosPK().getFecha();

     	   if(diaTarde.compareTo(inicio)>=0) {
     		   if(diaTarde.compareTo(fin)<=0) {
     			   TardanzasRango aux= new TardanzasRango();
     			   aux.setIdObrero(minutos.get(i).getMinutosPK().getObrerosidObrero());
     			   aux.setNomObrero(minutos.get(i).getObreros().getNombreYApellidos());
     			   aux.setFecha(minutos.get(i).getMinutosPK().getFecha());
     			   aux.setNumMinutos(minutos.get(i).getMinutosTarde());
     			   minutosDev.add(aux);
     		   }
     	   }
     
        }
		
		return minutosDev;
	}
	
	
	public List<Acumuladas> consulta3(Date inicio, Date fin) {

		List<Minutos> minutos = minutosRepository.findAll();
		List<TardanzasRango> minutosDev = new ArrayList<TardanzasRango>();
		List<Acumuladas> minutosAcum = new ArrayList<Acumuladas>();
		for (int i = 0; i < minutos.size(); i++) {
     	   Date diaTarde=minutos.get(i).getMinutosPK().getFecha();

     	   if(diaTarde.compareTo(inicio)>=0) {
     		   if(diaTarde.compareTo(fin)<=0) {
     			   TardanzasRango aux= new TardanzasRango();
     			   aux.setIdObrero(minutos.get(i).getMinutosPK().getObrerosidObrero());
     			   aux.setNomObrero(minutos.get(i).getObreros().getNombreYApellidos());
     			   aux.setFecha(minutos.get(i).getMinutosPK().getFecha());
     			   aux.setNumMinutos(minutos.get(i).getMinutosTarde());
     			   minutosDev.add(aux);
     		   }
     	   }
        }
		
		for (int i = 0; i < minutosDev.size(); i++) {
			Acumuladas aux= new Acumuladas();
			Obreros findObrero = obrerosService.findobreros(minutosDev.get(i).getIdObrero());
			aux.setCodArea( findObrero.getAreaidArea().getIdArea() );
			aux.setNomArea(findObrero.getAreaidArea().getNombreArea());
			aux.setIdObrero(minutosDev.get(i).getIdObrero());
			aux.setNomObrero(minutosDev.get(i).getNomObrero());
			
			
			int valor=yaEstaEnLista(i,minutosAcum);
			if(valor>0) {
				aux.setMinAcumulados(aux.getMinAcumulados()+valor);
				minutosAcum.set(i, aux);
			}else {
				aux.setMinAcumulados(valor);
				minutosAcum.add(aux);
			}
		}
		
		return minutosAcum;
	}



	private int yaEstaEnLista(int i, List<Acumuladas> minutosAcum) {
		for (int j = 0; j < minutosAcum.size(); j++) {
			if(minutosAcum.get(i).equals(minutosAcum.get(j))&&i!=j) {
				return minutosAcum.get(j).getMinAcumulados();
			}
		}
	
		return 0;
	}
	

}