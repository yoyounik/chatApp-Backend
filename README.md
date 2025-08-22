# 🚀 Real-Time Chat Application

A modern, real-time chat application built with Spring Boot backend and React frontend, featuring WebSocket communication, MongoDB persistence, and Docker containerization.

## �� Features

- **Real-time messaging** using WebSocket (STOMP)
- **Room-based chat system** - create and join chat rooms
- **User authentication** with username
- **Message persistence** in MongoDB
- **Responsive design** with Tailwind CSS
- **Docker containerization** for easy deployment
- **Deployed on Render (Backend) and Vercel (Frontend)**

## 🏗️ Architecture

- **Backend**: Spring Boot 3.5.4 + Java 17
- **Frontend**: React 19 + Vite + Tailwind CSS
- **Database**: MongoDB Atlas
- **Real-time**: WebSocket with STOMP
- **Containerization**: Docker
- **Deployment**: Render (Backend) + Vercel (Frontend)

## 🚀 Live Demo

- **Frontend**: [https://chat-app-frontend-fgtp.vercel.app/](https://chat-app-frontend-fgtp.vercel.app/)
- **Backend API**: [https://chatapp-backend-67bn.onrender.com](https://chatapp-backend-67bn.onrender.com)


## 🛠️ Prerequisites

- **Java 17** or higher
- **Node.js 18** or higher
- **MongoDB Atlas** account
- **Docker** (optional, for containerization)
- **Maven** (for backend)

## 🚀 Quick Start

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd chat-app-backend
   ```

2. **Configure MongoDB**
   - Create a MongoDB Atlas cluster
   - Get your connection string
   - Update environment variables in `src/main/resources/application.properties`

3. **Run locally**
   ```bash
   # Using Maven
   ./mvnw spring-boot:run
   
   # Or using Java
   ./mvnw clean package
   java -jar target/chat-app-backend-0.0.1-SNAPSHOT.jar
   ```

4. **Docker (optional)**
   ```bash
   # Build image
   docker build -t chat-app-backend .
   
   # Run container
   docker run -p 8080:8080 chat-app-backend
   ```

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd chat-app-frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure backend URL**
   - Update `src/config/AxiosHelper.js` with your backend URL
   - For production: `https://chatapp-backend-67bn.onrender.com`
   - For development: `http://localhost:8080`

4. **Run development server**
   ```bash
   npm run dev
   ```

5. **Build for production**
   ```bash
   npm run build
   ```

## �� Configuration

### Backend Environment Variables

Create a `.env` file or set these in your deployment platform:

```properties
# MongoDB Configuration
MONGODB_URI=mongodbu username and password - get it from MongoDB Atlas
MONGO_DATABASE=your_database_name

# CORS Configuration
ALLOWED_ORIGINS=https://your-frontend-domain.com,http://localhost:5173

# Server Configuration
PORT=8080
```

### Frontend Configuration

Update `src/config/AxiosHelper.js`:

```javascript
// Development
export const baseURL = "http://localhost:8080";

// Production
export const baseURL = "https://chatapp-backend-67bn.onrender.com";
```

## 🚀 Deployment

### Backend on Render

1. **Connect your GitHub repository**
2. **Set environment variables**:
   - `MONGODB_URI`
   - `MONGO_DATABASE`
   - `ALLOWED_ORIGINS`
3. **Deploy** - Render will automatically build and deploy using the Dockerfile

### Frontend on Vercel

1. **Connect your GitHub repository**
2. **Set build command**: `npm run build`
3. **Set output directory**: `dist`
4. **Deploy** - Vercel will automatically deploy on every push

## �� API Endpoints

### REST API

- `POST /api/v1/rooms` - Create a new chat room
- `GET /api/v1/rooms/{roomId}` - Join/get room information
- `GET /api/v1/rooms/{roomId}/messages` - Get room messages with pagination

### WebSocket Endpoints

- `/app/sendMessage/{roomId}` - Send message to a room
- `/topic/room/{roomId}` - Subscribe to room messages

## 🎨 Technologies Used

### Backend
- **Spring Boot 3.5.4** - Main framework
- **Spring WebSocket** - Real-time communication
- **Spring Data MongoDB** - Database operations
- **MongoDB** - NoSQL database
- **STOMP** - WebSocket messaging protocol
- **Maven** - Dependency management

### Frontend
- **React 19** - UI framework
- **Vite** - Build tool
- **Tailwind CSS** - Styling
- **Axios** - HTTP client
- **SockJS** - WebSocket client
- **React Router** - Navigation
- **React Hot Toast** - Notifications

## 🔒 Security Features

- **CORS configuration** for cross-origin requests
- **Input validation** on both frontend and backend
- **Secure WebSocket connections**

## 🧪 Testing

### Backend Testing
```bash
cd chat-app-backend
./mvnw test
```

### Frontend Testing
```bash
cd chat-app-frontend
npm run lint
```

## 📝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🐛 Troubleshooting

### Common Issues

1. **CORS Errors**
   - Ensure `ALLOWED_ORIGINS` environment variable is set correctly
   - Check that your frontend domain is included

2. **MongoDB Connection Issues**
   - Verify `MONGODB_URI` is correct
   - Check MongoDB Atlas network access settings

3. **WebSocket Connection Fails**
   - Ensure backend is running and accessible
   - Check CORS configuration

4. **Build Failures**
   - Ensure Java 17+ is installed
   - Check Maven dependencies

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Nikhil Sinha**

## �� Acknowledgments

- Spring Boot team for the excellent framework
- React team for the amazing frontend library
- MongoDB team for the robust database
- Render and Vercel for seamless deployment

---

⭐ **Star this repository if you found it helpful!**
