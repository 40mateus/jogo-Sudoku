@echo off
cls
echo Compilando arquivos Java...

:: Compila todos os arquivos .java no diretório atual
javac *.java

:: Verifica se a compilação teve sucesso
if %errorlevel% neq 0 (
    echo Erro na compilação. Verifique seu código.
    pause
    exit /b
)

:: Pergunta ao usuário se quer rodar com argumentos
set /p usarArgs="Deseja iniciar o Sudoku com valores automáticos? (s/n): "

if /i "%usarArgs%"=="s" (
    echo.
    echo Informe os 81 números separados por espaço (0 para vazio):
    set /p args=Digite os argumentos: 
    echo.
    echo Executando com os argumentos...
    java Main %args%
) else (
    echo.
    echo Executando com tabuleiro vazio...
    java Main
)

pause
