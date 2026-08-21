# vksonpdl-first-mcp

A Spring Boot-based **Model Context Protocol (MCP)** Server implementation integrating **Spring AI** and audio metadata extraction capabilities (via JAudioTagger).

This application exposes tools over the MCP WebMVC protocol to allow AI assistants (such as Claude Desktop, Cursor, or custom MCP clients) to query and inspect local FLAC audio files and metadata.

---

## 🚀 Features

- **MCP Protocol Integration**: Built on `spring-ai-starter-mcp-server-webmvc` to expose structured tools over HTTP/SSE transports.
- **Audio Metadata Extraction**: Integrates `jaudiotagger` for reading FLAC audio file metadata.
- **Exposed MCP Tools**:
  - `get-all-songs`: Returns all available FLAC file metadata objects.
  - `get-album-list`: Returns a distinct list of album titles.
  - `get-songs-by-album`: Performs an exact case-insensitive match on album names to list track info.
  - `get-songs-by-album-like`: Performs a fuzzy/partial match (`contains`) search on album names.

---

## 🛠️ Technology Stack

- **Java**: 17
- **Framework**: Spring Boot 4.1.0 / Spring AI 2.0.0
- **Transport**: Spring WebMVC (MCP HTTP/SSE Server)
- **Audio Processing**: JAudioTagger (`2.0.1`)
- **Utility**: Lombok

---

## 📋 Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
- **Apache Maven**: Version 3.8+ (or use Maven Wrapper if included)

---

## ⚙️ Building & Running

### 1. Build the Project
Clean and compile the project using Maven:
```bash
mvn clean package
```

### 2. Run the Application
Start the Spring Boot application locally:
```bash
mvn spring-boot:run
```
By default, the server runs on port `8080` and exposes MCP WebMVC endpoints (`/sse`).

---

## 🤖 MCP Integration Setup

To connect this MCP server to **Claude Desktop** or another MCP client:

Add the following entry to your `claude_desktop_config.json`:

```json
{
  "mcpServers": {
    "flac-mcp": {
      "command": "npx",
      "args": [
        "-y",
        "mcp-remote",
        "http://localhost:8080/sse"
      ]
    }
  }
}
```

---

## 📖 MCP Tools Overview

Below are the tools defined in `FlacMCP.java`:

| Tool Name | Parameter | Description |
| :--- | :--- | :--- |
| `get-all-songs` | *None* | Returns all available songs from the FLAC repository. |
| `get-album-list` | *None* | Returns a list of distinct album names. |
| `get-songs-by-album` | `albumName` (String) | Fetches tracks strictly matching the provided album name. |
| `get-songs-by-album-like` | `albumName` (String) | Fetches tracks with album names containing the input substring. |

---

## 📄 License

This project is licensed under standard open-source terms.
