# TeamManager Branch Information

## 🌿 Branches Overview

### `master` Branch
- **Purpose**: Basic TeamManager with in-memory storage
- **Features**: 
  - Add players to memory list
  - View all players
  - No database required
- **Use when**: Testing basic functionality, learning Spring Boot

### `teammanager_DB` Branch  
- **Purpose**: TeamManager with database storage
- **Features**:
  - All features from master
  - H2 Database integration
  - Persistent data storage
  - Database schema and data files
- **Use when**: Need persistent data, database functionality

## 🔍 How to Check Your Current Branch

```bash
# Quick check
git branch --show-current

# Detailed status
git status

# Run the check script
.\check-branch.ps1
```

## ⚠️ Important Notes

- **Always check your branch before running the app!**
- **Database features only work on `teammanager_DB` branch**
- **In-memory features work on both branches**
- **Switching branches changes your files automatically**

## 🚀 Running the Application

```bash
# Check branch first
.\check-branch.ps1

# Then run the app
.\mvnw spring-boot:run
``` 