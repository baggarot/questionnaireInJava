package questionnaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "QUESTIONS")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "question", nullable = false)
    private String question;

    @NotEmpty
    @Column(name = "first_answer", nullable = false)
    private String firstAnswer;

    @NotEmpty
    @Column(name = "second_answer", nullable = false)
    private String secondAnswer;

    @NotEmpty
    @Column(name = "third_answer", nullable = false)
    private String thirdAnswer;

    @NotEmpty
    @Column(name = "fourth_answer", nullable = false)
    private String fourthAnswer;

    @NotEmpty
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
}
