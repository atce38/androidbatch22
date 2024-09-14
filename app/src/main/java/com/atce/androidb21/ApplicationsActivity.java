package com.atce.androidb21;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atce.androidb21.adapter.CategoryAdapter;
import com.atce.androidb21.model.ApplicationModel;
import com.atce.androidb21.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class ApplicationsActivity extends AppCompatActivity {
    List<CategoryModel> categoryList = new ArrayList<>();
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_applications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        List<ApplicationModel> socialApps = new ArrayList<>();
        // Social Media Application Icon URLs
        String facebookIconUrl = "https://cdn-icons-png.flaticon.com/256/733/733547.png";
        String instagramIconUrl = "https://cdn-icons-png.freepik.com/256/15707/15707869.png";
        String twitterIconUrl = "https://cdn-icons-png.flaticon.com/256/124/124021.png";
        String snapchatIconUrl = "https://cdn-icons-png.flaticon.com/256/1384/1384066.png";
        String linkedInIconUrl = "https://cdn-icons-png.flaticon.com/256/174/174857.png";
        String tiktokIconUrl = "https://cdn-icons-png.flaticon.com/256/5968/5968812.png";
        String pinterestIconUrl = "https://cdn-icons-png.flaticon.com/256/145/145808.png";
        String redditIconUrl = "https://cdn-icons-png.flaticon.com/256/1384/1384051.png";
        String whatsappIconUrl = "https://cdn-icons-png.flaticon.com/256/152/152740.png";
        String telegramIconUrl = "https://cdn-icons-png.flaticon.com/256/4926/4926616.png";

// Adding social media applications with URLs
        socialApps.add(new ApplicationModel("Facebook", facebookIconUrl));
        socialApps.add(new ApplicationModel("Instagram", instagramIconUrl));
        socialApps.add(new ApplicationModel("Twitter", twitterIconUrl));
        socialApps.add(new ApplicationModel("Snapchat", snapchatIconUrl));
        socialApps.add(new ApplicationModel("LinkedIn", linkedInIconUrl));
        socialApps.add(new ApplicationModel("TikTok", tiktokIconUrl));
        socialApps.add(new ApplicationModel("Pinterest", pinterestIconUrl));
        socialApps.add(new ApplicationModel("Reddit", redditIconUrl));
        socialApps.add(new ApplicationModel("WhatsApp", whatsappIconUrl));
        socialApps.add(new ApplicationModel("Telegram", telegramIconUrl));

// Productivity Applications
        List<ApplicationModel> productivityApps = new ArrayList<>();


        String googleDriveIconUrl = "https://cdn-icons-png.flaticon.com/256/2702/2702602.png";
        String evernoteIconUrl = "https://cdn-icons-png.flaticon.com/256/145/145856.png";
        String slackIconUrl = "https://cdn-icons-png.flaticon.com/256/2111/2111615.png";
        String microsoftOfficeIconUrl = "https://cdn-icons-png.flaticon.com/256/732/732221.png";
        String asanaIconUrl = "https://cdn-icons-png.flaticon.com/256/732/732190.png";
        String todoistIconUrl = "https://cdn-icons-png.flaticon.com/256/732/732275.png";
        String trelloIconUrl = "https://cdn-icons-png.flaticon.com/256/2111/2111368.png";
        String notionIconUrl = "https://cdn-icons-png.flaticon.com/256/3580/3580176.png";
        String zoomIconUrl = "https://cdn-icons-png.flaticon.com/256/3829/3829567.png";
        String dropboxIconUrl = "https://cdn-icons-png.flaticon.com/256/174/174836.png";

// Adding productivity applications with URLs
        productivityApps.add(new ApplicationModel("Google Drive", googleDriveIconUrl));
        productivityApps.add(new ApplicationModel("Evernote", evernoteIconUrl));
        productivityApps.add(new ApplicationModel("Slack", slackIconUrl));
        productivityApps.add(new ApplicationModel("Microsoft Office", microsoftOfficeIconUrl));
        productivityApps.add(new ApplicationModel("Asana", asanaIconUrl));
        productivityApps.add(new ApplicationModel("Todoist", todoistIconUrl));
        productivityApps.add(new ApplicationModel("Trello", trelloIconUrl));
        productivityApps.add(new ApplicationModel("Notion", notionIconUrl));
        productivityApps.add(new ApplicationModel("Zoom", zoomIconUrl));
        productivityApps.add(new ApplicationModel("Dropbox", dropboxIconUrl));

// Entertainment Applications
        List<ApplicationModel> entertainmentApps = new ArrayList<>();
        // Entertainment Application Icon URLs
        String netflixIconUrl = "https://cdn-icons-png.flaticon.com/256/732/732228.png";
        String spotifyIconUrl = "https://cdn-icons-png.flaticon.com/256/2111/2111624.png";
        String youtubeIconUrl = "https://cdn-icons-png.flaticon.com/256/1384/1384060.png";
        String huluIconUrl = "https://cdn-icons-png.flaticon.com/256/888/888844.png";
        String primeVideoIconUrl = "https://cdn-icons-png.flaticon.com/256/5968/5968848.png";
        String disneyPlusIconUrl = "https://cdn-icons-png.flaticon.com/256/5968/5968995.png";
        String twitchIconUrl = "https://cdn-icons-png.flaticon.com/256/2111/2111688.png";
        String pandoraIconUrl = "https://cdn-icons-png.flaticon.com/256/725/725298.png";
        String appleMusicIconUrl = "https://cdn-icons-png.flaticon.com/256/1177/1177586.png";
        String hboMaxIconUrl = "https://cdn-icons-png.flaticon.com/256/5968/5968797.png";

// Adding entertainment applications with URLs
        entertainmentApps.add(new ApplicationModel("Netflix", netflixIconUrl));
        entertainmentApps.add(new ApplicationModel("Spotify", spotifyIconUrl));
        entertainmentApps.add(new ApplicationModel("YouTube", youtubeIconUrl));
        entertainmentApps.add(new ApplicationModel("Hulu", huluIconUrl));
        entertainmentApps.add(new ApplicationModel("Amazon Prime Video", primeVideoIconUrl));
        entertainmentApps.add(new ApplicationModel("Disney+", disneyPlusIconUrl));
        entertainmentApps.add(new ApplicationModel("Twitch", twitchIconUrl));
        entertainmentApps.add(new ApplicationModel("Pandora", pandoraIconUrl));
        entertainmentApps.add(new ApplicationModel("Apple Music", appleMusicIconUrl));
        entertainmentApps.add(new ApplicationModel("HBO Max", hboMaxIconUrl));


// Adding categories and their respective applications
        categoryList.add(new CategoryModel("Social Media", socialApps));
        categoryList.add(new CategoryModel("Productivity", productivityApps));
        categoryList.add(new CategoryModel("Entertainment", entertainmentApps));
        categoryList.add(new CategoryModel("Social Media1", socialApps));
        categoryList.add(new CategoryModel("Productivity2", productivityApps));
        categoryList.add(new CategoryModel("Entertainment3", entertainmentApps));

        RecyclerView categoryRecyclerView = findViewById(R.id.category_recycler_view);
         categoryAdapter = new CategoryAdapter(categoryList);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}