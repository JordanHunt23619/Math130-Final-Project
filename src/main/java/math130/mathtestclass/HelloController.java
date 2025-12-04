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
    private String[] questions = {
            "How high does an AP1 honda s2000 rev up to?",
            "How many gears does the Honda s2000 have?",
            "What motor does the Honda s2000 come with?",
            "How high does an AP1 honda s2000 rev up to?",
            "How much hp does my Honda S2000 make?",

    };
    private String[][] answers = {
            {"7.5krpm", "8.2krpm", "9.1krpm"},
            {"5 gears", "6 gears", "7 gears"},
            {"k24a2", "k20z1", "f20c1"},
            {"7.5krpm", "8.2krpm", "9.1krpm"},
            {"240 whp", "346whp", "505whp"}
    };
    private int[] correctAnswers = {2, 1, 2, 2, 2};

    private int questionIndex = 0;
    private int score = 0;


    @FXML
    private Label welcomeText;
    @FXML
    private Label prompt;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    @FXML
    public void initialize() {
        button1.setUserData(0);
        button2.setUserData(1);
        button3.setUserData(2);

    }


    @FXML
    protected void onButtonClick(Event event) {
        Node source = (Node) event.getSource();
        int answer = (int) source.getUserData();
        System.out.println(answer);
        if (answer == correctAnswers[questionIndex]) {
            score++;
        }

        questionIndex++;

        if (questionIndex < questions.length) {
            loadQuestion();

        } else {
            showResults();
        }
    }

    private void loadQuestion() {
        prompt.setText(questions[questionIndex]);

        button1.setText(answers[questionIndex][0]);
        button2.setText(answers[questionIndex][1]);
        button3.setText(answers[questionIndex][2]);
    }

    private void showResults() {
        prompt.setText("Congratulations, you finished \n you scored : " + score);
        button1.setText("vroom");
        button1.setDisable(true);
        button2.setText("vroom");
        button2.setDisable(true);
        button3.setText("vroom");
        button3.setDisable(true);
    }

    @FXML
    protected void onHelloButtonClick(Event event) throws IOException {

        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.sizeToScene();
        stage.setTitle("It works");
        stage.setScene(scene);
        stage.show();
    }
}
