# İlk Push

Yeni boş remote repository oluşturduktan sonra bu klasörde:

```powershell
git init
git add .
git commit -m "chore: initialize Relqor UI mock"
git branch -M main
git remote add origin <REMOTE_URL>
git push -u origin main
```

Önerilen erişim:
- UI Developer: write
- Core Android repository: erişim verilmez
- Backend repository: erişim verilmez
