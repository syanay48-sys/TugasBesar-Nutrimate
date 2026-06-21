@echo off
:loop
cls
echo ===================================================
echo     NutriMate Auto-Update GitHub Aktif! 🚀
echo ===================================================
echo Memeriksa perubahan kode NutriMate...

:: Mencari perubahan (file sampah otomatis diabaikan karena .gitignore)
git add .

:: Cek apakah ada kodingan baru yang berubah
git diff --cached --quiet
if %errorlevel% neq 0 (
    echo [INFO] Ada perubahan baru! Mengunggah ke GitHub...
    git commit -m "Auto-update NutriMate (%date% %time%)"
    git push origin main
    echo [SUKSES] Kode terbaru sudah meluncur ke GitHub!
) else (
    echo [AMAN] Tidak ada perubahan baru sejak update terakhir.
)

echo ===================================================
echo Menunggu 5 menit untuk pemeriksaan otomatis berikutnya...
timeout /t 300
goto loop