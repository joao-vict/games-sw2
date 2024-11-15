package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.repository.JogoRepository;
import application.model.Jogo;
import application.record.JogoDTO;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepo;

    public Iterable<JogoDTO> getAll() {
        return jogoRepo.findAll().stream().map(JogoDTO::new).toList();
    }

    public JogoDTO add(JogoDTO jogo) {
        return new JogoDTO(jogoRepo.save(new Jogo(jogo)));
    }
}
