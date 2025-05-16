#!/bin/bash

echo "🔍 Checking .env file presence..."
if [ -f .env ]; then
    echo "✅ .env file found"
else
    echo "❌ .env file NOT found"
fi

echo ""
echo "📦 Previewing environment variables related to Spring..."
env | grep -E 'SPRING_|AWS_|DB_|spring' | sort

echo ""
echo "🧪 Running Spring Boot app with debug config loading..."
mvn spring-boot:run -Dspring-boot.run.arguments="--logging.level.org.springframework.boot.context.config=DEBUG"
