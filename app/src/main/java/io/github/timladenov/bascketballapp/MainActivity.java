package io.github.timladenov.bascketballapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int teamAscore = 0;
    public int teamBscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            teamAscore = savedInstanceState.getInt("teamAscore");
            teamBscore = savedInstanceState.getInt("teamBscore");
        }
        setContentView(R.layout.activity_main);
        displayScoreOnRotate();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceStace) {
        savedInstanceStace.putInt("teamAscore", teamAscore);
        savedInstanceStace.putInt("teamBscore", teamBscore);
    }

    public void clickedButton(View view) {
        onClick(view);
    }

    public void onClick(View v) {
        String results = "Points: ";
        int id = v.getId();

        TextView resultA = (TextView) findViewById(R.id.resultTeamA);
        TextView resultB = (TextView) findViewById(R.id.resultTeamB);

        switch (id) {
            case R.id.teamA3p:
                teamAscore = teamAscore + 3;
                returnResult(teamAscore, results, resultA);
                break;
            case R.id.teamA2p:
                teamAscore = teamAscore + 2;
                returnResult(teamAscore, results, resultA);
                break;
            case R.id.teamAfreeThrow:
                teamAscore++;
                returnResult(teamAscore, results, resultA);
                break;
            case R.id.teamB3p:
                teamBscore = teamBscore + 3;
                returnResult(teamBscore, results, resultB);
                break;
            case R.id.teamB2p:
                teamBscore = teamBscore + 2;
                returnResult(teamBscore, results, resultB);
                break;
            case R.id.teamBfreeThrow:
                teamBscore++;
                returnResult(teamBscore, results, resultB);
                break;
            case R.id.zeroResult:
                teamAscore = teamBscore = 0;
                returnResult(teamAscore, results, resultA);
                returnResult(teamBscore, results, resultB);
                break;
        }
    }

    public void returnResult(int result, String tmp2, TextView id) {
        String parser = tmp2 + String.valueOf(result);
        id.setText(parser);
    }

    public void displayScoreOnRotate() {
        TextView resultA = (TextView) findViewById(R.id.resultTeamA);
        String tmp1 = "Points: " + teamAscore;
        resultA.setText(tmp1);
        TextView resultB = (TextView) findViewById(R.id.resultTeamB);
        String tmp2 = "Points: " + teamBscore;
        resultB.setText(tmp2);
    }
}
