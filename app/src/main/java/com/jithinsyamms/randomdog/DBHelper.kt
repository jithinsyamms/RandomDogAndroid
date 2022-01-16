package com.jithinsyamms.randomdog

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        Log.d("RandomDog","JithinSyam onCreate called in db")
        db.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL(SQL_DELETE_TABLE)
        onCreate(db)
    }

    fun getAllImages() : ArrayList<RandomDog> {
        val db = this.readableDatabase
        val imageList = ArrayList<RandomDog>()
        val cursor = db.rawQuery(FETCH_DOGS_QUERY, null)

        if (cursor.moveToFirst()){
            do {
                val image = Utils.getImage(cursor.getBlob(1))
                if (image != null) {
                    val dog = RandomDog(cursor.getString(0), image)
                    imageList.add(dog)
                }
            } while (cursor.moveToNext())
        }

        return imageList
    }

    fun addImage(key: String, image: ByteArray) {
        val values = ContentValues()
        values.put(DOGS_COLUMN_KEY, key)
        values.put(DOGS_COLUMN_IMAGE, image)
        val db = this.writableDatabase
        val res = db.insert(DATABASE_TABLE_NAME, null, values)
        Log.d("RandomDog","JithinSyam inserted to DB $res")
    }

    fun delete(key: String) {
        val db = this.writableDatabase
        val deletedRows = db.delete(DATABASE_TABLE_NAME, "$DOGS_COLUMN_KEY=?", arrayOf(key))
        Log.d("RandomDog","JithinSyam deleted from DB $deletedRows")
    }

    fun deleteAll() {
        val db = this.writableDatabase
        db.execSQL(SQL_DELETE_ALL_ENTRIES)
    }


    companion object {

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "RandomDog.db"
        private const val DATABASE_TABLE_NAME = "dogs"
        private const val DOGS_COLUMN_KEY = "key"
        private const val DOGS_COLUMN_IMAGE = "image"

        const val SQL_CREATE_TABLE =  "CREATE TABLE " + DATABASE_TABLE_NAME + " (" +
        DBHelper.DOGS_COLUMN_KEY + " TEXT PRIMARY KEY, " +
        DOGS_COLUMN_IMAGE + " BLOB )"

        const val SQL_DELETE_ALL_ENTRIES = " DELETE FROM $DATABASE_TABLE_NAME"
        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $DATABASE_TABLE_NAME"
        const val FETCH_DOGS_QUERY = "SELECT * FROM $DATABASE_TABLE_NAME ORDER BY $DOGS_COLUMN_KEY "
    }
}