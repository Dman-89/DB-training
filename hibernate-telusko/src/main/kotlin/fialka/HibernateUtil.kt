package fialka

import fialka.entity.Alien
import fialka.entity.Laptop
import fialka.entity.Student
import org.hibernate.SessionFactory
import org.hibernate.boot.Metadata
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistry
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Environment
import org.hibernate.tool.schema.Action
import java.sql.DriverManager

class HibernateUtil {

    companion object {

        val sessionFactory = buildSessionFactory()

        private fun buildSessionFactory(): SessionFactory {
            createDatabaseIfNotExists()
            val standardRegistry: StandardServiceRegistry =
                StandardServiceRegistryBuilder()
                    .applySetting(Environment.URL, "jdbc:postgresql://localhost:5432/neon")
                    .applySetting(Environment.USER, "postgres")
                    .applySetting(Environment.PASS, "postgres")
                    .applySetting(Environment.DRIVER, "org.postgresql.Driver")
                    .applySetting(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
                    .applySetting(Environment.SHOW_SQL, "true")
                    .applySetting(Environment.FORMAT_SQL, "true")
                    .applySetting(Environment.DEFAULT_SCHEMA, "fialka")
                    .applySetting(Environment.HBM2DDL_AUTO, Action.CREATE_DROP) // Hibernate will drop and create tables according to annotated classes below
//                    .applySetting(Environment.HBM2DDL_AUTO, Action.UPDATE) // Hibernate will drop and create tables according to annotated classes below
                    .applySetting(Environment.HBM2DDL_CREATE_NAMESPACES, "true") // for creation of schema also

                    .build()


            val metaData: Metadata = MetadataSources(standardRegistry)
                .addAnnotatedClass(Alien::class.java)
                .addAnnotatedClass(Laptop::class.java)
                .addAnnotatedClass(Student::class.java)
                .metadataBuilder
                .build()

            return metaData.sessionFactoryBuilder.build()
        }

        fun createDatabaseIfNotExists() {
            val connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgres")
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("SELECT count(*) from pg_database where datname = 'neon'")
            resultSet.next()
            val count = resultSet.getInt(1)
            if (count <= 0) {
                statement.executeUpdate("CREATE DATABASE neon");
            }
            statement.close()
            connection.close()
        }

    }
}