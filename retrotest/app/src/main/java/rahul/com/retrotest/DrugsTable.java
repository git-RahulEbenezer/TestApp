package rahul.com.retrotest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sharath on 13/06/2018.
 */

public class DrugsTable {
    public static String DATABASE_NAME;
    public static int DATABASE_VERSION;
    public static String DATABASE_CREATE;

    public SQLiteDatabase db;
    private DataBaseHelper dbHelper;
    Context context;

    public DrugsTable(Context context) {
        this.context = context;
        DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS Drugs(\n" +
                "        Drug_Id INTEGER,Org_Id INTEGER,Unit_Id INTEGER, Durg_Code TEXT,Genric_name TEXT,Ethical_name TEXT,Drug_Type_Id INTEGER,\n" +
                "        Group_Id INTEGER,Status INTEGER,Created_By INTEGER,Created_Date TEXT,Edited_By INTEGER,Edited_Date TEXT,\n" +
                "        Total_Dosage TEXT,Drug_Mode TEXT)";
        DATABASE_VERSION = 11;
        DATABASE_NAME = "watif.db";

        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
    public DrugsTable open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String Drug_Id,String Org_Id,String Unit_Id,String Durg_Code,String Genric_name,String Ethical_name,
                            String Drug_Type_Id,String Group_Id,String Status,String Created_By,String Created_Date,String Edited_By,
                            String Edited_Date,String Total_Dosage,String Drug_Mode) {


        ContentValues newValues = new ContentValues();
        newValues.put(context.getResources().getString(R.string.tag_DrugId), Drug_Id);
        newValues.put(context.getResources().getString(R.string.tag_OrgId), Org_Id);
        newValues.put(context.getResources().getString(R.string.tag_UnitId), Unit_Id);
        newValues.put(context.getResources().getString(R.string.tag_DurgCode), Durg_Code);
        newValues.put(context.getResources().getString(R.string.tag_Genricname), Genric_name);
        newValues.put(context.getResources().getString(R.string.tag_Ethicalname), Ethical_name);
        newValues.put(context.getResources().getString(R.string.tag_DrugTypeId), Drug_Type_Id);
        newValues.put(context.getResources().getString(R.string.tag_groupid), Group_Id);
        newValues.put(context.getResources().getString(R.string.tag_Status), Status);
        newValues.put(context.getResources().getString(R.string.tag_CreatedBy), Created_By);
        newValues.put(context.getResources().getString(R.string.tag_CreatedDate), Created_Date);
        newValues.put(context.getResources().getString(R.string.tag_editedby), Edited_By);
        newValues.put(context.getResources().getString(R.string.tag_editeddate), Edited_Date);
        newValues.put(context.getResources().getString(R.string.tag_Total_Dosage), Total_Dosage);
        newValues.put(context.getResources().getString(R.string.tag_DrugMode), Drug_Mode);

        db.insert(context.getResources().getString(R.string.table_Drugs), null, newValues);
    }

    public ArrayList<HashMap<String, String>> getDrugsInfo() {
        ArrayList<HashMap<String, String>> getDescInfoArray = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT " + context.getResources().getString(R.string.tag_DrugId)
                + "," + context.getResources().getString(R.string.tag_Genricname)
                + " FROM " + context.getResources().getString(R.string.table_Drugs) + " ORDER BY Genric_name ";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> getDescInfo = new HashMap<String, String>();
                getDescInfo.put(context.getResources().getString(R.string.tag_DrugId), cursor.getString(0));
                getDescInfo.put(context.getResources().getString(R.string.tag_Genricname), cursor.getString(1));
                getDescInfoArray.add(getDescInfo);
            } while (cursor.moveToNext());
        }
        return getDescInfoArray;
    }
    public int getRecordCount() {
        String selectQuery = "SELECT * FROM " + context.getResources().getString(R.string.table_Drugs) ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor.getCount();
    }

    public ArrayList<String> getDrugIDGenricNameAL(String Org_Id) {
        ArrayList<String> getCrtdDtAL = new ArrayList<String>();

        String selectQuery = "SELECT Genric_name FROM " + context.getResources().getString(R.string.table_Drugs) + " WHERE "
                + context.getResources().getString(R.string.tag_OrgId) + "='" + Org_Id + "'" + " OR " + context.getResources().getString(R.string.tag_OrgId) + " = 4 ";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {

            do {
                getCrtdDtAL.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        return getCrtdDtAL;
    }

    /**
     * for sending bulk data to server for synchronization
     */
    public JSONArray getDrugdJArraySync(String org_id, int limit) {
        JSONArray getChildImmunization = new JSONArray();


        String selectQuery = "SELECT * FROM ( SELECT * FROM " + context.getResources().getString(R.string.table_Drugs) + " WHERE "
                + context.getResources().getString(R.string.tag_OrgId) + "='"
                + org_id + "' OR " + context.getResources().getString(R.string.tag_OrgId) + " = 4  ORDER BY Drug_Id"
                + " DESC LIMIT '" + limit + "') ORDER BY Drug_Id " + "";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                JSONObject jObject = new JSONObject();
                try {
                    jObject.put(context.getResources().getString(R.string.tag_OrgId), cursor.getString(1));
                    jObject.put(context.getResources().getString(R.string.tag_UnitId), cursor.getString(2));
                    jObject.put(context.getResources().getString(R.string.tag_DurgCode), cursor.getString(3));
                    jObject.put(context.getResources().getString(R.string.tag_Genricname), cursor.getString(4));
                    jObject.put(context.getResources().getString(R.string.tag_Ethicalname), cursor.getString(5));
                    jObject.put(context.getResources().getString(R.string.tag_DrugTypeId), cursor.getString(6));
                    jObject.put(context.getResources().getString(R.string.tag_CreatedBy), cursor.getString(9));
                    jObject.put(context.getResources().getString(R.string.tag_CreatedDate), cursor.getString(10));
                    jObject.put(context.getResources().getString(R.string.tag_DrugMode), cursor.getString(14));

                } catch (JSONException e) {

                }
                getChildImmunization.put(jObject);
            } while (cursor.moveToNext());
        }
        return getChildImmunization;
    }

    public int getMaxId() {
        int intMaxId=0;
        String selectQuery = "SELECT ifnull(max(" + context.getResources().getString(R.string.tag_DrugId)  + "),0) FROM " + context.getResources().getString(R.string.table_Drugs) ;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {

            intMaxId=(cursor.getInt(0));

        }
        return intMaxId;
    }


    public void deleteRows(){
        db.delete(context.getString(R.string.table_Drugs),null,null);
    }

    public boolean deleteRows(String org_id) {
        return db.delete(context.getResources().getString(R.string.table_Drugs),
                context.getResources().getString(R.string.tag_OrgId) + "='" + org_id +"'" + " OR "
                        + context.getResources().getString(R.string.tag_OrgId) + " = 4 ", null) > 0;
    }

}
