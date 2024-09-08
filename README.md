# Spring Currency Converter API

## Overview
The **Spring-currency-converter API** is a RESTful API built with Spring Boot that allows users to convert currencies using real-time exchange rates. It fetches live currency rates from an external exchange rate API and provides endpoints for converting amounts between different currencies and listing supported currency rates.

## Features
- Convert an amount from one currency to another.
- Get real-time exchange rates for a specific base currency.
- Simple and intuitive API design.

## Technologies Used
- **Spring Boot**: Backend framework.
- **RestTemplate/WebClient**: For making HTTP calls to external APIs.
- **ExchangeRate-API**: For fetching real-time exchange rates.
- **Maven**: Dependency management.
- **Java 17+**: Programming language.

## API Endpoints

| Method | Endpoint                     | Description                                      |
|--------|------------------------------|--------------------------------------------------|
| `GET`  | `/api/currency/{currency}`    | Get exchange rates for the specified base currency (e.g., USD). |
| `GET`  | `/api/currency/convert`       | Convert an amount from one currency to another (e.g., USD to EUR). |

### Example Usage

1. **Get Exchange Rates:**
   ```bash
   GET http://localhost:8080/api/currency/USD
   ```

   Sample response:
   ```json
   {
     "base": "USD",
     "rates": {
       "EUR": 0.91,
       "GBP": 0.75,
       "JPY": 110.25
     }
   }
   ```

2. **Convert Currency:**
   ```bash
   GET http://localhost:8080/api/currency/convert?from=USD&to=EUR&amount=100
   ```

   Sample response:
   ```json
   {
     "Converted Amount": "91.00"
   }
   ```

## How to Run the Project

### Prerequisites:
- Java 17+
- Maven

### Steps to Run:

1. **Clone the repository**:
   ```bash
   git clone  https://github.com/MReza-90/Spring-Currency-Converter-API.git
   cd spring-currency-converter-api
   ```

2. **Update the API Key**:
   - Replace `YOUR-API-KEY` in `CurrencyService` with your API key from [ExchangeRate-API](https://www.exchangerate-api.com/).

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**:
   The application will run by default on `http://localhost:8080`.

## Project Structure

```
src/
│
├── main/
│   ├── java/com/example/currencyconverter/
│   │   ├── controller/           # REST controllers
│   │   ├── service/              # Currency conversion logic
│   │   └── SpringCurrencyConverterApplication.java  # Main application
│   └── resources/
│       ├── application.properties # Application config
└── test/                          # Unit tests
```

## How to Contribute

1. Fork the repository.
2. Create a new branch for your feature: `git checkout -b feature-name`.
3. Make your changes and commit: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Create a pull request.

