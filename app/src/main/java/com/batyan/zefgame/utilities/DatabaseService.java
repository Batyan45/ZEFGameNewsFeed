package com.batyan.zefgame.utilities;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.batyan.zefgame.App;
import com.batyan.zefgame.R;
import com.batyan.zefgame.model.ArticleModel;
import com.batyan.zefgame.repository.resources.database.ILocalDatabase;
import com.batyan.zefgame.repository.resources.database.LocalDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DatabaseService extends IntentService {

    private String path;
    App app = App.getInstance();
    Toast toast = Toast.makeText(app.getApplicationContext(),
            app.getString(R.string.news_loading), Toast.LENGTH_SHORT);

    public DatabaseService() {
        super(DatabaseService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent != null) {
            path = intent.getStringExtra("url");
            String xml = getData();
            RSSParser parser = new RSSParser(xml);
            List<ArticleModel> articles = parser.getRssItems();
            ILocalDatabase iLocalDatabase = new LocalDatabase(app.getDatabase());
            iLocalDatabase.insertArticle(articles);
        }
    }

    private String getData() {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder("");

        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setReadTimeout(10000);
            connection.connect();
            toast.show();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            reader.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
            toast.setText("Проверьте интернет-соединение");
            toast.show();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
