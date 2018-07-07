package daggerok.api;

import daggerok.extensions.CaptureSystemOutput;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@CaptureSystemOutput
@DisplayName("JUnit 5 modern tests")
class ObservableTest {

  //TODO
}
