package com.givenchdy.cvbuilder.cvbuilder.Helpers;

import android.content.Context;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

    public class ContextSingleton {

        //Does not need to be static because we create one instance
        //of this singleton class:
        private Context context;

        //The protected private instance:
        private static ContextSingleton instance = null;

        private ContextSingleton() {
            //Prevents instationation of the singleton, have to use the
            //getInstance method.
        }

        //The singleton getInstance method:
        public static ContextSingleton getInstance() {
            if (instance == null) {
                instance = new ContextSingleton ();
            }
            return instance;
        }

        public static Context getContext() {
            return getInstance().context;
        }

        public void setContext(Context context) {
            this.context = context;
        }


    }
