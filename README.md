# 🔗 Encurtador de URL

Um encurtador de URL moderno e eficiente desenvolvido em Java com Spring Boot, permitindo criar links curtos e gerenciar estatísticas de acesso.

## ✨ Funcionalidades

- **🔗 Encurtamento de URLs**: Transforme URLs longas em links curtos e fáceis de compartilhar
- **📊 Estatísticas de Cliques**: Acompanhe quantas vezes cada link foi acessado
- **📋 Listagem Paginada**: Visualize todos os links encurtados com paginação
- **🔄 Redirecionamento Automático**: Acesso transparente às URLs originais
- **🎯 IDs Únicos**: Geração automática de identificadores únicos para cada URL

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Maven**
- **Hibernate**

## 📋 Endpoints da API

### `POST /shorten-url`
Encurta uma URL e retorna o link encurtado.

**Body:**
```json
{
  "url": "https://www.exemplo.com/url-muito-longa-e-complicada"
}
```

**Response:**
```json
{
  "shortUrl": "http://localhost:8080/abc123",
  "originalUrl": "https://www.exemplo.com/url-muito-longa-e-complicada"
}
```

### `GET /{id}`
Redireciona para a URL original baseada no ID encurtado. Basta pegar o url encurtado e jogar
no navegador, com o codigo rodando

### `GET /links`

Retorna todas as URLs encurtadas com paginação.

Parâmetros:
- page - Número da página (padrão: 0)
- size - Tamanho da página (padrão: 5)

**Response:**
```json
{
  "content": [
    {
      "id": "abc123",
      "shortUrl": "http://localhost:8080/abc123",
      "originalUrl": "https://www.exemplo.com/pagina-muito-longa",
      "clicks": 15
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "size": 5,
  "number": 0
}
```

