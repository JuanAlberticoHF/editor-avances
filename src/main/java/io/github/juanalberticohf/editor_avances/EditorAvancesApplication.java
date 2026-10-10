package io.github.juanalberticohf.editor_avances;

import io.github.juanalberticohf.editor_avances.persistence.entities.Avance;
import io.github.juanalberticohf.editor_avances.persistence.repositories.IAvanceRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class EditorAvancesApplication implements CommandLineRunner {

	private final IAvanceRepository avanceRepository;

	public EditorAvancesApplication(IAvanceRepository avanceRepository) {
		this.avanceRepository = avanceRepository;
	}

	@Override
	public void run(String @NonNull ... args) {
		// Aqui añadir los avances de prueba a la base de datos
		avanceRepository.saveAll(
				java.util.List.of(
						new Avance(null,
								"La edad de piedra",
								"Pica piedra con tu nuevo pico de madera hasta obtener tus primeros bloques de adoquín.",
								LocalDateTime.now().minusDays(10),
								LocalDateTime.now().minusDays(10)),

						new Avance(null,
								"¡Buena pinta!",
								"Funde mineral de hierro en el horno para forjar tu primera armadura de protección.",
								LocalDateTime.now().minusDays(9),
								LocalDateTime.now().minusDays(8)),

						new Avance(null,
								"¡Diamantes!",
								"Adéntrate en las profundidades de las cuevas y extrae tus primeras gemas de diamante.",
								LocalDateTime.now().minusDays(8),
								LocalDateTime.now().minusDays(7)),

						new Avance(null,
								"Hacia las profundidades",
								"Construye y enciende un portal de obsidiana para adentrarte en la dimensión del Nether.",
								LocalDateTime.now().minusDays(7),
								LocalDateTime.now().minusDays(7)),

						new Avance(null,
								"En llamas",
								"Derrota a un Blaze en una fortaleza del Nether para conseguir varas de fuego ardientes.",
								LocalDateTime.now().minusDays(6),
								LocalDateTime.now().minusDays(5)),

						new Avance(null,
								"Boticario local",
								"Prepara tu primer soporte para pociones y elabora una poción útil con verrugas del Nether.",
								LocalDateTime.now().minusDays(5),
								LocalDateTime.now().minusDays(4)),

						new Avance(null,
								"Ojo de espía",
								"Combina polvo de blaze con perlas de ender y sigue la trayectoria de los ojos hasta la fortaleza subterránea.",
								LocalDateTime.now().minusDays(4),
								LocalDateTime.now().minusDays(3)),

						new Avance(null,
								"El fin...",
								"Atraviesa el portal del End y accede a la desolada isla central del vacío.",
								LocalDateTime.now().minusDays(3),
								LocalDateTime.now().minusDays(2)),

						new Avance(null,
								"Libera el End",
								"Destruye los cristales de curación y derrota al temible Dragón del Fin para abrir el portal de regreso.",
								LocalDateTime.now().minusDays(2),
								LocalDateTime.now().minusDays(1)),

						new Avance(null,
								"El cielo es el límite",
								"Encuentra un barco flotante en las Ciudades del End y equípate con un par de élitros para planear por los cielos.",
								LocalDateTime.now().minusHours(5),
								LocalDateTime.now())
				)
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(EditorAvancesApplication.class, args);
	}

}
