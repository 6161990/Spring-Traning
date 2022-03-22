import numberguessing.console.AppModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppModel_specs {

    private static final String NEW_LINE = System.lineSeparator();

    @Test
    void sut_is_incompleted_when_it_is_initalized(){
        var sut = new AppModel(new PositiveIntegerGeneratorStub(50));
        boolean actual = sut.isCompleted();
        assertFalse(actual);
    }

    @Test
    void sut_correctly_prints_select_mode_message() {
        var sut = new AppModel(new PositiveIntegerGeneratorStub(50));
        String actual = sut.flushOutput();

        assertThat(actual).isEqualTo("1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE +
                "3: Exit" + NEW_LINE + "Enter selection: ");

    }

    @Test
    void sut_correctly_exist() {
        var sut = new AppModel(new PositiveIntegerGeneratorStub(50));
        sut.processInput("3");

        boolean actual = sut.isCompleted();
        assertTrue(actual);

    }

    @Test
    void sut_correctly_prints_single_player_game_start_message() {
        var sut = new AppModel(new PositiveIntegerGeneratorStub(50));
        sut.flushOutput();
        sut.processInput("1");

        String actual = sut.flushOutput();

        assertThat(actual).isEqualTo("Single player game Start!" + NEW_LINE + "I'm thinking of a number between 1 and 100." + NEW_LINE + "Enter your guess: ");
    }
}

/**
 * [Test1. sut가 초기화되고나면 완료된 상태가 아니다] PositiveIntegerGeneratorStub 생성
 * [Test2. sut의 첫 flushOutput 게임모드선택 옵션 메세지다]
 * [Test3. sut에 게임모드선택메세지출력 후 3을 입력값으로 넣으면 sut는 종료된다]
 * [Test4. sut에 싱글게임모드선택 후 게임 시작 메세지가 출력된다.]
 *
 * */