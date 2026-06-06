// Pregunta 1 – Implementación de DAO Base (3 puntos)
// Implemente la clase abstracta DaoBase considerando:
// ● Configuración de conexión JDBC.
// ● Método getConnection().
// ● Uso de herencia para reutilizar la conexión.
// ● Declare dos métodos abstractos:
// ○ crear()
// ○ borrar()

package com.lab6.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Veterinaria", "root", "12345678");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
        }
        return connection;
    }

    public abstract void crear() throws SQLException;

    public abstract void borrar() throws SQLException;
}
