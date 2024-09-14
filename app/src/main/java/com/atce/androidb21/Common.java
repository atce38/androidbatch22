package com.atce.androidb21;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Intent;

public class Common {
    public static void startMyActivity(Activity source, Class<?> destination) {
        source.startActivity(new Intent(source,destination));
        source.finish();
    }
}
