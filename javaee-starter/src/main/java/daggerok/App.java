package daggerok;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

import static javax.json.stream.JsonGenerator.PRETTY_PRINTING;

@ApplicationScoped
@ApplicationPath("")
public class App extends Application {

  @Override
  public Map<String, Object> getProperties() {
//    return singletonMap(PRETTY_PRINTING, true);
    return new HashMap<String, Object>() {{
      put(PRETTY_PRINTING, true);
    }};
  }
}
