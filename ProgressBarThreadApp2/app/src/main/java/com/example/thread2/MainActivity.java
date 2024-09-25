package com.example.thread2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;

import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {
    private TextView progressText;
    private Button btn;
    private ProgressBar progressBar;
    //create a counter variable
    private int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        progressText=findViewById(R.id.tv);
        progressBar=findViewById(R.id.progressBar2);
        btn=findViewById(R.id.button);
    }

    public void submit(View view)
    {
        //create the new class object
        NewClass obj=new NewClass();
        obj.execute();
    }
    private  class NewClass extends AsyncTask<Void,Integer,String> {
        protected void onPreExecute() {
            //UI updation to be performed before background/time
            //Disable the button once the task is running
            btn.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(Void... voids) {
            for (progress = 0; progress <= 100; progress++) {
                try {
                    Thread.sleep(50);
                    publishProgress(progress);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "COMPLETED";
        }

        protected void onProgressUpdate(Integer... progress) {
            progressBar.setProgress(progress[0]);
            progressText.setText("Progress:" + progress[0] + "%");
        }

        protected void onPostExecute(String result) {
            btn.setEnabled(true);
            progressText.setText(result);
            progressBar.setVisibility(View.GONE);
        }
    }
}

