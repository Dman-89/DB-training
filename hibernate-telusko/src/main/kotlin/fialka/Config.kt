//package fialka
//
//import fialka.entity.Alien
//import org.hibernate.SessionFactory
//import org.hibernate.boot.Metadata
//import org.hibernate.boot.MetadataSources
//import org.hibernate.boot.registry.StandardServiceRegistry
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder
//import org.hibernate.cfg.Environment
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//open class Config {
//
//    @Bean
//    open fun sessionFactory(): SessionFactory {
//        val standardRegistry: StandardServiceRegistry =
//            StandardServiceRegistryBuilder()
//                .applySetting(Environment.URL, "jdbc:postgresql://localhost:5432/neon")
//                .applySetting(Environment.USER, "postgres")
//                .applySetting(Environment.PASS, "postgres")
//                .applySetting(Environment.DRIVER, "org.postgresql.Driver")
//                .applySetting(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
//                .applySetting(Environment.SHOW_SQL, "true")
//                .applySetting(Environment.FORMAT_SQL, "true")
//                .applySetting(Environment.DEFAULT_SCHEMA, "fialka")
//                .applySetting(Environment.HBM2DDL_AUTO, "create") // Hibernate will drop and create tables according to annotated classes below
//                .applySetting(Environment.HBM2DDL_CREATE_NAMESPACES, "true") // for creation of schema also
//
//                .build()
//
//
//        val metaData: Metadata = MetadataSources(standardRegistry)
//            .addAnnotatedClass(Alien::class.java)
//            .metadataBuilder
//            .build()
//
//        return metaData.sessionFactoryBuilder.build()
//    }
//}