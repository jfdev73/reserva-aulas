import java.util.List;

import com.miranda.proyectoaulas.model.Aula;
import com.miranda.proyectoaulas.repository.AulaRepositoryImpl;
import com.miranda.proyectoaulas.util.JpaUtil;

import jakarta.persistence.EntityManager;

public class Main {
	
	public static void main(String[] args) {
		 AulaRepositoryImpl  aulaRepository =  new AulaRepositoryImpl();
		 
		 //List<Aula> aulas = aulaRepository.getAll();
		 
		 //aulas.forEach(System.out::println);
		 
		 Aula aula = aulaRepository.findById(1L);
		 aula.setDescripcion("Aula para experimentos de biologia y fisica.");
		 aulaRepository.update(aula);
		 System.out.println("By Id: " +aula );
		
	}

}
