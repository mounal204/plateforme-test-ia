package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EvaluationDto;
import com.example.demo.dto.QcmRequestDto;
import com.example.demo.dto.ReponseEtudiantDto;
import com.example.demo.dto.ResultatDto;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.entity.Evaluationentity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.QuestionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.example.demo.model.Question;
import com.example.demo.repository.EvaluationRepository;

@Service
public class EvaluationService {

	private final EvaluationRepository repository;
	private final QuestionRepository questionRepository;
	public EvaluationService(
	        EvaluationRepository repository,
	        QuestionRepository questionRepository) {

	    this.repository = repository;
	    this.questionRepository = questionRepository;
	}

    public Evaluationentity create(Evaluationentity e) {
        return repository.save(e);
    }

    public List<Evaluationentity> getAll() {
        return repository.findAll();
    }

    public Evaluationentity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Evaluation not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Evaluationentity update(Long id, Evaluationentity newData) {

        Evaluationentity e = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Evaluation not found"));

        e.setTitre(newData.getTitre());
        e.setObjectif(newData.getObjectif());

        return repository.save(e);
    }

    // =========================
    // 🤖 PARTIE IA (AJOUTÉE)
    // =========================

    // 1. Fake IA (simulation)
    public String fakeAiResponse() {

        return """
    [
      {
        "question": "Qu'est-ce que l'encapsulation en Java ?",
        "reponse": "C'est le fait de cacher les données et les protéger avec des getters/setters."
      },
      {
        "question": "Quel est le rôle de l'héritage ?",
        "reponse": "Permet de réutiliser le code d'une classe mère."
      },
      {
        "question": "Qu'est-ce que le polymorphisme ?",
        "reponse": "C'est la capacité d'une méthode à avoir plusieurs comportements."
      },
      {
        "question": "Pourquoi utiliser les classes abstraites ?",
        "reponse": "Pour définir une base commune sans instancier directement."
      }
    ]
    """;
    }


    // 3. Conversion JSON → Java Object
    public List<Question> convertAiResponse(String json) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(json);


            JsonNode questionsNode;


            // format {"questions":[...]}
            if(root.has("questions")) {

                questionsNode = root.get("questions");

            } else {

                questionsNode = root;

            }



            List<Question> questions = new ArrayList<>();


            for(JsonNode node : questionsNode) {


                Question q = new Question();


                q.setQuestion(
                        node.get("question").asText()
                );


                JsonNode reponses = node.get("reponses");



                q.setChoixA(
                        reponses.get(0).asText()
                );


                q.setChoixB(
                        reponses.get(1).asText()
                );


                q.setChoixC(
                        reponses.get(2).asText()
                );


                q.setChoixD(
                        reponses.get(3).asText()
                );



                q.setBonneReponse(
                        node.get("bonneReponse").asText()
                );



                questions.add(q);


            }


            return questions;



        } catch(Exception e) {


            e.printStackTrace();


            throw new RuntimeException(
                    "Erreur lors du parsing JSON IA"
            );

        }

    }
    // 4. Méthode complète (option recommandée)
    public List<Question> generateQuestions(
            QcmRequestDto request) {

        List<Question> questions = new ArrayList<>();

        int nb = request.getNombreQuestions();

        List<String> objectifs =
                request.getObjectifs();

        for (int i = 0; i < nb; i++) {

            String objectif =
                    objectifs.get(
                            i % objectifs.size()
                    );

            Question q = new Question();

            q.setQuestion(
                    "Question " + (i + 1)
                    + " sur " + objectif
            );

            q.setBonneReponse(
                    "Réponse sur "
                    + objectif
                    + " en "
                    + request.getSujet()
            );

            questions.add(q);
        }

        return questions;
    }
   
    public String buildPrompt(QcmRequestDto request) {


        return """

        Génère %d questions QCM sur le sujet : %s.

        Retourne uniquement un objet json valide.

        Le format obligatoire est :

        {
          "questions":[

            {
              "question":"texte de la question",

              "reponses":[
                 "choix A",
                 "choix B",
                 "choix C",
                 "choix D"
              ],

              "bonneReponse":"choix correct"

            }

          ]
        }


        Ne mets aucun texte avant ou après le json.


        """.formatted(

                request.getNombreQuestions(),

                request.getSujet()

        );


    }

	public QuestionRepository getQuestionRepository() {
		return questionRepository;
	}
	public void saveQuestions(List<Question> questions) {

	    for (Question q : questions) {

	        QuestionEntity entity = new QuestionEntity();

	        entity.setQuestion(q.getQuestion());
	        entity.setChoixA(q.getChoixA());
	        entity.setChoixB(q.getChoixB());
	        entity.setChoixC(q.getChoixC());
	        entity.setChoixD(q.getChoixD());
	        entity.setQuestion(q.getQuestion());
	        entity.setBonneReponse(q.getBonneReponse());

	        QuestionEntity saved =
	                questionRepository.save(entity);

	        q.setId(saved.getId());

	        System.out.println("ID généré : " + entity.getId());
	    }
	}
	public ResultatDto corriger(EvaluationDto evaluation) {

	    System.out.println("=== CORRECTION ===");

	    if (evaluation == null) {
	        throw new RuntimeException("Evaluation null");
	    }

	    if (evaluation.getReponses() == null) {
	        throw new RuntimeException("Liste des réponses null");
	    }

	    System.out.println(
	            "Nombre de réponses reçues : "
	            + evaluation.getReponses().size()
	    );

	    int bonnesReponses = 0;

	    for (ReponseEtudiantDto reponse : evaluation.getReponses()) {

	        System.out.println(
	                "Question ID : "
	                + reponse.getQuestionId()
	        );

	        QuestionEntity question =
	                questionRepository.findById(
	                        reponse.getQuestionId()
	                ).orElseThrow(
	                        () -> new RuntimeException(
	                                "Question introuvable : "
	                                + reponse.getQuestionId()
	                        )
	                );

	        System.out.println(
	                "Bonne réponse BD : "
	                + question.getBonneReponse()
	        );

	        System.out.println(
	                "Réponse étudiant : "
	                + reponse.getReponseChoisie()
	        );

	        if (question.getBonneReponse()
	                .equalsIgnoreCase(
	                        reponse.getReponseChoisie()
	                )) {

	            bonnesReponses++;
	        }
	    }

	    int totalQuestions =
	            evaluation.getReponses().size();

	    double note =
	            (bonnesReponses * 20.0)
	            / totalQuestions;

	    ResultatDto resultat =
	            new ResultatDto();

	    resultat.setBonnesReponses(
	            bonnesReponses
	    );

	    resultat.setTotalQuestions(
	            totalQuestions
	    );

	    resultat.setNote(
	            note
	    );

	    return resultat;
	}
	
	


}