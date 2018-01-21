package tomerbu.edu.quizprep.gmail;

import java.util.ArrayList;

import tomerbu.edu.quizprep.gmail.models.GmailModel;

public interface GmailListener{
        void onResult(ArrayList<GmailModel> data);
        void onError(Exception e);
}
