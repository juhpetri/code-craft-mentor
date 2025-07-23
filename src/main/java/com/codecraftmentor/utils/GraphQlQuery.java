package com.codecraftmentor.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GraphQlQuery {

    public static final String QUERY_NAME_CLIENTES = "clientes";
    public static final String QUERY_NAME_CRIAR_CLIENTE = "criarCliente";
    public static final String QUERY_NAME_CLIENTE_POR_EMAIL = "clientePorEmail";

    public static final String QUERY_CADASTRAR_CLIENTE = """
            mutation CriarCliente($nome: String!, $email: String!) {
              criarCliente(input: {
                nome: $nome,
                email: $email
              }) {
                id
                nome
                email
              }
            }""";
    public static final String QUERY_CONSULTAR_CLIENTE_EMAIL = """
            query ClientePorEmail ($email: String!) {
                      clientePorEmail(email: $email) {
                        id
                        nome
                        email
                      }
                    }""";

    public static final String QUERY_LISTAR_CLIENTE = """
            query {
              clientes {
                id
                nome
                email
              }
            }""";
}
