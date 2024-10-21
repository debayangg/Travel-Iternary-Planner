import logo from './logo.svg';
import Navbar from './components/Navbar';
import './App.css';

function App() {
  return (
    <div className="App">
      {/* Navbar */}
      <Navbar />

      {/* Home Section */}
      <section id="home" className="section">
        <h1>Welcome to Travel Itinerary Planner</h1>
        <p>Plan your perfect trip effortlessly!</p>
        <img src="https://via.placeholder.com/600x300" alt="Travel banner" />
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vel 
          urna sed erat commodo feugiat. Donec vehicula consectetur turpis, in 
          aliquam turpis facilisis vel. Phasellus in dignissim ipsum.
        </p>
      </section>

      {/* About Section */}
      <section id="about" className="section">
        <h2>About Us</h2>
        <p>This app helps you plan your travels by organizing destinations, activities, and itineraries.</p>
        <img src="https://via.placeholder.com/500x200" alt="About banner" />
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla interdum 
          purus id velit pharetra, vel gravida neque fermentum. Nam quis eros sit 
          amet est dignissim facilisis. Vestibulum ullamcorper velit quis turpis 
          commodo, nec efficitur augue tincidunt.
        </p>
      </section>

      {/* Services Section */}
      <section id="services" className="section">
        <h2>Our Services</h2>
        <p>We offer a wide range of services to help you plan your trip, from destination recommendations to itinerary management.</p>
        <img src="https://via.placeholder.com/400x250" alt="Services banner" />
        <p>
          Phasellus in enim quis augue auctor facilisis. Ut luctus est in eros 
          gravida, quis tincidunt ex finibus. Aenean posuere arcu at felis 
          facilisis, id malesuada eros hendrerit. Integer tempus convallis elit, 
          sit amet dictum libero congue ut.
        </p>
      </section>

      {/* Contact Section */}
      <section id="contact" className="section">
        <h2>Contact Us</h2>
        <p>If you have any questions, feel free to reach out to us!</p>
        <img src="https://via.placeholder.com/350x200" alt="Contact banner" />
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat 
          volutpat. Nam luctus, ligula et tincidunt efficitur, sapien erat 
          malesuada dolor, eget vehicula odio justo vel nisl. Sed tincidunt dui 
          vel quam interdum suscipit.
        </p>
      </section>

      {/* Footer */}
    </div>
  );
}

export default App;
