package com.spotlightapps18.masterielts.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import static com.spotlightapps18.masterielts.data.QuestionDatabaseContract.*;

public class QuestionProvider extends ContentProvider {

    private QuestionDatabaseHelper mQuestionDatabaseHelper;

    private static final int QUESTION = 100;
    private static final int QUESTION_ID = 101;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(CONTENT_AUTHORITY,PATH_QUESTIONS,QUESTION);
        sUriMatcher.addURI(CONTENT_AUTHORITY,PATH_QUESTION_ID,QUESTION_ID);
    }


    @Override
    public boolean onCreate() {
        mQuestionDatabaseHelper = new QuestionDatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query( Uri uri, String[] projection, String selection, String[] selectionArgs,  String sortOrder) {
        SQLiteDatabase database = mQuestionDatabaseHelper.getReadableDatabase();
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        switch (match){
            case QUESTION:
                cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs
                        ,null,null,sortOrder);
                break;

            case QUESTION_ID:
                selection = QuestionEntry.Q_ID +"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(QuestionEntry.QUESTION_TABLE_NAME,projection,selection,selectionArgs
                        ,null,null,sortOrder);
                break;
             default:
                 throw new IllegalArgumentException("Can not query Unknown uri");
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert( Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case QUESTION:
                return insertQuestion(uri,contentValues);
                default:
                    throw new IllegalArgumentException("Can not insert Unknown uri");
        }
    }

    private Uri insertQuestion(Uri uri, ContentValues contentValues) {
        SQLiteDatabase database = mQuestionDatabaseHelper.getWritableDatabase();
        long id = database.insert(QuestionEntry.QUESTION_TABLE_NAME,null,contentValues);
        return ContentUris.withAppendedId(uri,id);
    }


    @Override
    public int delete( Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri,ContentValues contentValues,String selection, String[] selectionArgs) {

        final int match = sUriMatcher.match(uri);
        SQLiteDatabase database = mQuestionDatabaseHelper.getWritableDatabase();
        switch (match){
            case QUESTION:
                int id =database.update(QuestionEntry.QUESTION_TABLE_NAME,contentValues,selection,selectionArgs);
                return id;
            case QUESTION_ID:
                selection = QuestionEntry.Q_ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return database.update(QuestionEntry.QUESTION_TABLE_NAME,contentValues,selection,selectionArgs);
            default:
                throw new IllegalArgumentException("Can not update Unknown uri");
        }
    }
}
