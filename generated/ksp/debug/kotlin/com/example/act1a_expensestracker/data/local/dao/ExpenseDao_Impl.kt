package com.example.act1a_expensestracker.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.act1a_expensestracker.`data`.local.entity.ExpenseEntity
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ExpenseDao_Impl(
  __db: RoomDatabase,
) : ExpenseDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfExpenseEntity: EntityInsertAdapter<ExpenseEntity>

  private val __deleteAdapterOfExpenseEntity: EntityDeleteOrUpdateAdapter<ExpenseEntity>

  private val __updateAdapterOfExpenseEntity: EntityDeleteOrUpdateAdapter<ExpenseEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfExpenseEntity = object : EntityInsertAdapter<ExpenseEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `expenses` (`id`,`amount`,`categoryId`,`categoryName`,`note`,`timestamp`,`dateString`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ExpenseEntity) {
        statement.bindLong(1, entity.id)
        statement.bindDouble(2, entity.amount)
        statement.bindLong(3, entity.categoryId)
        statement.bindText(4, entity.categoryName)
        statement.bindText(5, entity.note)
        statement.bindLong(6, entity.timestamp)
        statement.bindText(7, entity.dateString)
      }
    }
    this.__deleteAdapterOfExpenseEntity = object : EntityDeleteOrUpdateAdapter<ExpenseEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `expenses` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: ExpenseEntity) {
        statement.bindLong(1, entity.id)
      }
    }
    this.__updateAdapterOfExpenseEntity = object : EntityDeleteOrUpdateAdapter<ExpenseEntity>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `expenses` SET `id` = ?,`amount` = ?,`categoryId` = ?,`categoryName` = ?,`note` = ?,`timestamp` = ?,`dateString` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: ExpenseEntity) {
        statement.bindLong(1, entity.id)
        statement.bindDouble(2, entity.amount)
        statement.bindLong(3, entity.categoryId)
        statement.bindText(4, entity.categoryName)
        statement.bindText(5, entity.note)
        statement.bindLong(6, entity.timestamp)
        statement.bindText(7, entity.dateString)
        statement.bindLong(8, entity.id)
      }
    }
  }

  public override suspend fun insertExpense(expense: ExpenseEntity): Long = performSuspending(__db,
      false, true) { _connection ->
    val _result: Long = __insertAdapterOfExpenseEntity.insertAndReturnId(_connection, expense)
    _result
  }

  public override suspend fun deleteExpense(expense: ExpenseEntity): Unit = performSuspending(__db,
      false, true) { _connection ->
    __deleteAdapterOfExpenseEntity.handle(_connection, expense)
  }

  public override suspend fun updateExpense(expense: ExpenseEntity): Unit = performSuspending(__db,
      false, true) { _connection ->
    __updateAdapterOfExpenseEntity.handle(_connection, expense)
  }

  public override fun getAllExpenses(): Flow<List<ExpenseEntity>> {
    val _sql: String = "SELECT * FROM expenses ORDER BY timestamp DESC"
    return createFlow(__db, false, arrayOf("expenses")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfCategoryName: Int = getColumnIndexOrThrow(_stmt, "categoryName")
        val _columnIndexOfNote: Int = getColumnIndexOrThrow(_stmt, "note")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfDateString: Int = getColumnIndexOrThrow(_stmt, "dateString")
        val _result: MutableList<ExpenseEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ExpenseEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpCategoryName: String
          _tmpCategoryName = _stmt.getText(_columnIndexOfCategoryName)
          val _tmpNote: String
          _tmpNote = _stmt.getText(_columnIndexOfNote)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpDateString: String
          _tmpDateString = _stmt.getText(_columnIndexOfDateString)
          _item =
              ExpenseEntity(_tmpId,_tmpAmount,_tmpCategoryId,_tmpCategoryName,_tmpNote,_tmpTimestamp,_tmpDateString)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getExpensesByDateRange(startTimestamp: Long, endTimestamp: Long):
      Flow<List<ExpenseEntity>> {
    val _sql: String =
        "SELECT * FROM expenses WHERE timestamp >= ? AND timestamp <= ? ORDER BY timestamp DESC"
    return createFlow(__db, false, arrayOf("expenses")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, startTimestamp)
        _argIndex = 2
        _stmt.bindLong(_argIndex, endTimestamp)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfCategoryName: Int = getColumnIndexOrThrow(_stmt, "categoryName")
        val _columnIndexOfNote: Int = getColumnIndexOrThrow(_stmt, "note")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfDateString: Int = getColumnIndexOrThrow(_stmt, "dateString")
        val _result: MutableList<ExpenseEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ExpenseEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpCategoryName: String
          _tmpCategoryName = _stmt.getText(_columnIndexOfCategoryName)
          val _tmpNote: String
          _tmpNote = _stmt.getText(_columnIndexOfNote)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpDateString: String
          _tmpDateString = _stmt.getText(_columnIndexOfDateString)
          _item =
              ExpenseEntity(_tmpId,_tmpAmount,_tmpCategoryId,_tmpCategoryName,_tmpNote,_tmpTimestamp,_tmpDateString)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getExpensesByDateString(dateString: String): Flow<List<ExpenseEntity>> {
    val _sql: String = "SELECT * FROM expenses WHERE dateString = ? ORDER BY timestamp DESC"
    return createFlow(__db, false, arrayOf("expenses")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, dateString)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfCategoryName: Int = getColumnIndexOrThrow(_stmt, "categoryName")
        val _columnIndexOfNote: Int = getColumnIndexOrThrow(_stmt, "note")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfDateString: Int = getColumnIndexOrThrow(_stmt, "dateString")
        val _result: MutableList<ExpenseEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ExpenseEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpCategoryName: String
          _tmpCategoryName = _stmt.getText(_columnIndexOfCategoryName)
          val _tmpNote: String
          _tmpNote = _stmt.getText(_columnIndexOfNote)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpDateString: String
          _tmpDateString = _stmt.getText(_columnIndexOfDateString)
          _item =
              ExpenseEntity(_tmpId,_tmpAmount,_tmpCategoryId,_tmpCategoryName,_tmpNote,_tmpTimestamp,_tmpDateString)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getExpensesByCategoryId(categoryId: Long): Flow<List<ExpenseEntity>> {
    val _sql: String = "SELECT * FROM expenses WHERE categoryId = ? ORDER BY timestamp DESC"
    return createFlow(__db, false, arrayOf("expenses")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, categoryId)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfCategoryName: Int = getColumnIndexOrThrow(_stmt, "categoryName")
        val _columnIndexOfNote: Int = getColumnIndexOrThrow(_stmt, "note")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfDateString: Int = getColumnIndexOrThrow(_stmt, "dateString")
        val _result: MutableList<ExpenseEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ExpenseEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpCategoryName: String
          _tmpCategoryName = _stmt.getText(_columnIndexOfCategoryName)
          val _tmpNote: String
          _tmpNote = _stmt.getText(_columnIndexOfNote)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpDateString: String
          _tmpDateString = _stmt.getText(_columnIndexOfDateString)
          _item =
              ExpenseEntity(_tmpId,_tmpAmount,_tmpCategoryId,_tmpCategoryName,_tmpNote,_tmpTimestamp,_tmpDateString)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getExpenseById(id: Long): ExpenseEntity? {
    val _sql: String = "SELECT * FROM expenses WHERE id = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfCategoryName: Int = getColumnIndexOrThrow(_stmt, "categoryName")
        val _columnIndexOfNote: Int = getColumnIndexOrThrow(_stmt, "note")
        val _columnIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _columnIndexOfDateString: Int = getColumnIndexOrThrow(_stmt, "dateString")
        val _result: ExpenseEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpCategoryName: String
          _tmpCategoryName = _stmt.getText(_columnIndexOfCategoryName)
          val _tmpNote: String
          _tmpNote = _stmt.getText(_columnIndexOfNote)
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp)
          val _tmpDateString: String
          _tmpDateString = _stmt.getText(_columnIndexOfDateString)
          _result =
              ExpenseEntity(_tmpId,_tmpAmount,_tmpCategoryId,_tmpCategoryName,_tmpNote,_tmpTimestamp,_tmpDateString)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteExpenseById(id: Long) {
    val _sql: String = "DELETE FROM expenses WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
