package math130.mathtestclass;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;

public class HelloController {
    // Array of Quiz questions
    private String[] questions = {
            "How high does an AP1 Honda s2000 rev up to?",
            "How many gears does the Honda s2000 have?",
            "What motor does the Honda s2000 come with?",
            "What year is my Honda S2000?",
            "How much hp does my Honda S2000 make?",

    };
    // A 2D Array of possible answers to the quiz questions
    private String[][] answers = {
            {"7.5krpm", "8.2krpm", "9krpm"},
            {"5 gears", "6 gears", "7 gears"},
            {"k24a2", "k20z1", "f20c1"},
            {"2001", "2006", "2002"},
            {"240whp", "346whp", "505whp"}
    };
    // An Array holidng the index of the correct Answers to the Questions
    private int[] correctAnswers = {2, 1, 2, 2, 2};
    // this keeps track of the current question index
    private int questionIndex = 0;
    // keeps track of the user's score if they got the question right.
    private int score = 0;

    // FXML elements
    @FXML
    private Label welcomeText; // label for the welcome text scene 1
    @FXML
    private Label prompt; // label to show the question
    @FXML
    private Button button1; // button for the first answer
    @FXML
    private Button button2; // button for the second answer
    @FXML
    private Button button3; // button for the third answer

    /**
     * this method is called automatically when the FXML is loaded,
     * it initializes the buttons and loads right into the first question
     */
    @FXML
    public void initialize() {
        // wrapped the text into the label because it was too long
        prompt.setWrapText(true);
        // this stores the index of each button as user data to help keep with score
        button1.setUserData(0);
        button2.setUserData(1);
        button3.setUserData(2);

        // calls this method to load right into the first question after
        //scene 1 or welcome scene
        loadQuestion();

    }

    /**
     * This handles the clicks on the answer button
     * This checks to see if the answer is correct, it keeps score
     * then it moves onto the next question
     * @param event
     */
    @FXML
    protected void onButtonClick(Event event) {
        Node source = (Node) event.getSource();
        int answer = (int) source.getUserData();
        System.out.println(answer);
        // checks to see if the selected answer is correct
        if (answer == correctAnswers[questionIndex]) {
            // if it is, then it updates score
            score++;
        }
        // moves onto the next question
        questionIndex++;

        // if there is another question, then it wil load the next question
        if (questionIndex < questions.length) {
            loadQuestion();

        } else {
            // if no more questions, it will load the final result
            showResults();
        }
    }

    /**
     * This loads the current question, then it updates the buttons text with
     * the proper answer choices
     */
    private void loadQuestion() {
        // this sets the question text
        prompt.setText(questions[questionIndex]);

        // this sets the text of each answer button
        button1.setText(answers[questionIndex][0]);
        button2.setText(answers[questionIndex][1]);
        button3.setText(answers[questionIndex][2]);
    }

    /**
     * This displays the final score for the user after all the
     * questions were answered, it also disables the buttons
     */
    private void showResults() {
        //this displays the score to the user
        prompt.setText("Nice! you got " + score + " right!");

        //this disables all of the buttons and also displays a text
        button1.setText("vroom");
        button1.setDisable(true);

        button2.setText("vroom");
        button2.setDisable(true);

        button3.setText("vroom");
        button3.setDisable(true);
    }

    @FXML
    protected void onHelloButtonClick(Event event) throws IOException {
        // creates a new stage or window
        Stage stage = new Stage();
        // load the FXML to scene 2
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("It works");
        // sets the scene and display the window
        stage.setScene(scene);
        stage.show();
    }
}
