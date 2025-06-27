# Check Branch Script
Write-Host "=== BRANCH CHECK ===" -ForegroundColor Yellow
$currentBranch = git branch --show-current
Write-Host "Current Branch: $currentBranch" -ForegroundColor Green

if ($currentBranch -eq "master") {
    Write-Host "⚠️  You are on MASTER branch" -ForegroundColor Red
    Write-Host "   Database features are NOT available here!" -ForegroundColor Red
} elseif ($currentBranch -eq "teammanager_DB") {
    Write-Host "✅ You are on TEAMMANAGER_DB branch" -ForegroundColor Green
    Write-Host "   Database features ARE available here!" -ForegroundColor Green
}

Write-Host "==================" -ForegroundColor Yellow 