package com.example.act1a_expensestracker.`data`.local.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.act1a_expensestracker.`data`.local.entity.UserEntity
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfUserEntity: EntityInsertAdapter<UserEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfUserEntity = object : EntityInsertAdapter<UserEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `users` (`email`,`name`,`passwordHash`,`profileImageUri`,`monthlyIncome`) VALUES (?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: UserEntity) {
        statement.bindText(1, entity.email)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.passwordHash)
        val _tmpProfileImageUri: String? = entity.profileImageUri
        if (_tmpProfileImageUri == null) {
          statement.bindNull(4)
        } else {
          statement.bindText(4, _tmpProfileImageUri)
        }
        statement.bindDouble(5, entity.monthlyIncome)
      }
    }
  }

  public override suspend fun insertUser(user: UserEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __insertAdapterOfUserEntity.insert(_connection, user)
  }

  public override suspend fun getUserByEmail(email: String): UserEntity? {
    val _sql: String = "SELECT * FROM users WHERE email = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, email)
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfPasswordHash: Int = getColumnIndexOrThrow(_stmt, "passwordHash")
        val _columnIndexOfProfileImageUri: Int = getColumnIndexOrThrow(_stmt, "profileImageUri")
        val _columnIndexOfMonthlyIncome: Int = getColumnIndexOrThrow(_stmt, "monthlyIncome")
        val _result: UserEntity?
        if (_stmt.step()) {
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpPasswordHash: String
          _tmpPasswordHash = _stmt.getText(_columnIndexOfPasswordHash)
          val _tmpProfileImageUri: String?
          if (_stmt.isNull(_columnIndexOfProfileImageUri)) {
            _tmpProfileImageUri = null
          } else {
            _tmpProfileImageUri = _stmt.getText(_columnIndexOfProfileImageUri)
          }
          val _tmpMonthlyIncome: Double
          _tmpMonthlyIncome = _stmt.getDouble(_columnIndexOfMonthlyIncome)
          _result =
              UserEntity(_tmpEmail,_tmpName,_tmpPasswordHash,_tmpProfileImageUri,_tmpMonthlyIncome)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateProfileImage(email: String, uri: String) {
    val _sql: String = "UPDATE users SET profileImageUri = ? WHERE email = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, uri)
        _argIndex = 2
        _stmt.bindText(_argIndex, email)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateMonthlyIncome(email: String, income: Double) {
    val _sql: String = "UPDATE users SET monthlyIncome = ? WHERE email = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindDouble(_argIndex, income)
        _argIndex = 2
        _stmt.bindText(_argIndex, email)
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
