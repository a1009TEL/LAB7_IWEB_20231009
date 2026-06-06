package com.lab6.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lab6.app.bean.Dueno;
import com.lab6.app.bean.Especie;
import com.lab6.app.bean.Mascota;
import com.lab6.app.bean.Veterinario;

public class MascotaDAO extends BaseDAO {

    // Variables para crear
    private String nombre;
    private int edad;
    private float peso;
    private int especie_id;
    private int veterinario_id;
    private int dueno_id;

    // Variables para borrar
    private int id;

    public void setupCrear(String nombre, int edad, float peso, int especie_id, int veterinario_id, int dueno_id)
            throws SQLException {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.especie_id = especie_id;
        this.veterinario_id = veterinario_id;
        this.dueno_id = dueno_id;
    }

    public void setupBorrar(int id) {
        this.id = id;
    }

    public void crear() throws SQLException {
        String sql = """
                INSERT INTO mascota(nombre, edad, peso, especie_id, veterinario_id, dueno_id)
                VALUES(?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setDouble(3, peso);
            ps.setInt(4, especie_id);
            ps.setInt(5, veterinario_id);
            ps.setInt(6, dueno_id);
        }
    };

    public void borrar() throws SQLException {
        String sql = """
                DELETE FROM mascota
                WHERE idmascota = ?;
                """;

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
        }
    };

    public List<Mascota> getAll() throws SQLException {
        List<Mascota> mascotas = new ArrayList<>();
        String sql = """
                    SELECT
                    m.idmascota,
                    m.nombre,
                    m.edad,
                    m.peso,
                    e.nombre AS especie,
                    v.nombre AS veterinario_nombre,
                    v.especialidad AS veterinario_especialidad,
                    d.nombre AS dueno_nombre,
                    d.telefono AS dueno_telefono
                    FROM mascota m
                    INNER JOIN especie e
                    ON m.especie_id = e.idespecie
                    INNER JOIN veterinario v
                    ON m.veterinario_id = v.idveterinario
                    INNER JOIN dueno d
                    ON m.dueno_id = d.iddueno;
                """;

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mascota mascota = new Mascota();

                mascota.setNombre(rs.getString("nombre"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setPeso(rs.getFloat("peso"));

                mascota.setEspecie(new Especie(rs.getString("especie")));
                mascota.setVeterinario(new Veterinario(
                        rs.getString("veterinario_nombre"),
                        rs.getString("veterinario_especialidad")));
                mascota.setDueno(new Dueno(
                        rs.getString("dueno_nombre"),
                        rs.getString("dueno_telefono")));
            }
        }
        return mascotas;
    }
}
