package com.example.flightsearch.data.providers.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flightsearch.model.Airport;
import com.example.flightsearch.model.Favorite;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FlightDao_Impl implements FlightDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Favorite> __insertionAdapterOfFavorite;

  private final EntityDeletionOrUpdateAdapter<Favorite> __deletionAdapterOfFavorite;

  public FlightDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavorite = new EntityInsertionAdapter<Favorite>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `favorite` (`id`,`departure_code`,`destination_code`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favorite value) {
        stmt.bindLong(1, value.getId());
        if (value.getDepartureCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDepartureCode());
        }
        if (value.getDestinationCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDestinationCode());
        }
      }
    };
    this.__deletionAdapterOfFavorite = new EntityDeletionOrUpdateAdapter<Favorite>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favorite` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favorite value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Object insertFavoriteFlight(final Favorite flight,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavorite.insert(flight);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteFavoriteFlight(final Favorite flight,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavorite.handle(flight);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllFavorites(final Continuation<? super List<Favorite>> continuation) {
    final String _sql = "\n"
            + "        Select * from favorite\n"
            + "        ORDER BY id ASC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Favorite>>() {
      @Override
      public List<Favorite> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDepartureCode = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_code");
          final int _cursorIndexOfDestinationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "destination_code");
          final List<Favorite> _result = new ArrayList<Favorite>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Favorite _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDepartureCode;
            if (_cursor.isNull(_cursorIndexOfDepartureCode)) {
              _tmpDepartureCode = null;
            } else {
              _tmpDepartureCode = _cursor.getString(_cursorIndexOfDepartureCode);
            }
            final String _tmpDestinationCode;
            if (_cursor.isNull(_cursorIndexOfDestinationCode)) {
              _tmpDestinationCode = null;
            } else {
              _tmpDestinationCode = _cursor.getString(_cursorIndexOfDestinationCode);
            }
            _item = new Favorite(_tmpId,_tmpDepartureCode,_tmpDestinationCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Favorite>> getAllFavoritesFlow() {
    final String _sql = "\n"
            + "        Select * from favorite\n"
            + "        ORDER BY id ASC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"favorite"}, new Callable<List<Favorite>>() {
      @Override
      public List<Favorite> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDepartureCode = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_code");
          final int _cursorIndexOfDestinationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "destination_code");
          final List<Favorite> _result = new ArrayList<Favorite>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Favorite _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDepartureCode;
            if (_cursor.isNull(_cursorIndexOfDepartureCode)) {
              _tmpDepartureCode = null;
            } else {
              _tmpDepartureCode = _cursor.getString(_cursorIndexOfDepartureCode);
            }
            final String _tmpDestinationCode;
            if (_cursor.isNull(_cursorIndexOfDestinationCode)) {
              _tmpDestinationCode = null;
            } else {
              _tmpDestinationCode = _cursor.getString(_cursorIndexOfDestinationCode);
            }
            _item = new Favorite(_tmpId,_tmpDepartureCode,_tmpDestinationCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getSingleFavorite(final String departureCode, final String destinationCode,
      final Continuation<? super Favorite> continuation) {
    final String _sql = "\n"
            + "        SELECT * FROM favorite\n"
            + "        WHERE departure_code = ?\n"
            + "          AND destination_code = ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (departureCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, departureCode);
    }
    _argIndex = 2;
    if (destinationCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, destinationCode);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Favorite>() {
      @Override
      public Favorite call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDepartureCode = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_code");
          final int _cursorIndexOfDestinationCode = CursorUtil.getColumnIndexOrThrow(_cursor, "destination_code");
          final Favorite _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDepartureCode;
            if (_cursor.isNull(_cursorIndexOfDepartureCode)) {
              _tmpDepartureCode = null;
            } else {
              _tmpDepartureCode = _cursor.getString(_cursorIndexOfDepartureCode);
            }
            final String _tmpDestinationCode;
            if (_cursor.isNull(_cursorIndexOfDestinationCode)) {
              _tmpDestinationCode = null;
            } else {
              _tmpDestinationCode = _cursor.getString(_cursorIndexOfDestinationCode);
            }
            _result = new Favorite(_tmpId,_tmpDepartureCode,_tmpDestinationCode);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Airport>> getAllAirportsFlow() {
    final String _sql = "\n"
            + "        Select * from airport \n"
            + "        ORDER BY id ASC \n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"airport"}, new Callable<List<Airport>>() {
      @Override
      public List<Airport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final List<Airport> _result = new ArrayList<Airport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Airport _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _item = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Airport>> getAllAirportsFlow(final String query) {
    final String _sql = "\n"
            + "    Select * from airport\n"
            + "    WHERE iata_code = ? OR name LIKE '%' || ? || '%'        \n"
            + "    ORDER BY name ASC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"airport"}, new Callable<List<Airport>>() {
      @Override
      public List<Airport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final List<Airport> _result = new ArrayList<Airport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Airport _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _item = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAllAirports(final Continuation<? super List<Airport>> continuation) {
    final String _sql = "\n"
            + "        Select * from airport \n"
            + "        ORDER BY id ASC \n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Airport>>() {
      @Override
      public List<Airport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final List<Airport> _result = new ArrayList<Airport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Airport _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _item = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllAirports(final String query,
      final Continuation<? super List<Airport>> continuation) {
    final String _sql = "\n"
            + "    Select * from airport\n"
            + "    WHERE iata_code = ? OR name LIKE '%' || ? || '%'        \n"
            + "    ORDER BY name ASC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Airport>>() {
      @Override
      public List<Airport> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final List<Airport> _result = new ArrayList<Airport>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Airport _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _item = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAirportByCode(final String code,
      final Continuation<? super Airport> continuation) {
    final String _sql = "\n"
            + "    Select * from airport\n"
            + "    WHERE iata_code = ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Airport>() {
      @Override
      public Airport call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final Airport _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _result = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<Airport> getAirportByCodeFlow(final String code) {
    final String _sql = "\n"
            + "    Select * from airport\n"
            + "    WHERE iata_code = ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"airport"}, new Callable<Airport>() {
      @Override
      public Airport call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final Airport _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _result = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAirportById(final int id, final Continuation<? super Airport> continuation) {
    final String _sql = "\n"
            + "    Select * from airport\n"
            + "    WHERE id = ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Airport>() {
      @Override
      public Airport call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iata_code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPassengers = CursorUtil.getColumnIndexOrThrow(_cursor, "passengers");
          final Airport _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCode;
            if (_cursor.isNull(_cursorIndexOfCode)) {
              _tmpCode = null;
            } else {
              _tmpCode = _cursor.getString(_cursorIndexOfCode);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpPassengers;
            _tmpPassengers = _cursor.getInt(_cursorIndexOfPassengers);
            _result = new Airport(_tmpId,_tmpCode,_tmpName,_tmpPassengers);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
