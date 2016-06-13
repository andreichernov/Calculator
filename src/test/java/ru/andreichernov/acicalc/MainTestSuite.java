package ru.andreichernov.acicalc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleaner;
import ru.andreichernov.acicalc.cleaners.EmptyCharacterCleanerTest;
import ru.andreichernov.acicalc.converters.Infix2PostfixConverterTest;
import ru.andreichernov.acicalc.evaluator.PostfixExprEvaluatorTest;
import ru.andreichernov.acicalc.math.SolverTest;
import ru.andreichernov.acicalc.operand.BaseOperandTest;
import ru.andreichernov.acicalc.operand.NotationTest;
import ru.andreichernov.acicalc.operator.BaseOperatorTest;
import ru.andreichernov.acicalc.operator.OperatorsHelperTest;
import ru.andreichernov.acicalc.validation.ExpressionValidatorSimpleImplTest;

@RunWith(Suite.class)
@SuiteClasses({
        ConsoleHelperTest.class,
        ExpressionValidatorSimpleImplTest.class,
        EmptyCharacterCleanerTest.class,
        SolverTest.class,
        BaseOperandTest.class,
        NotationTest.class,
        OperatorsHelperTest.class,
        BaseOperatorTest.class,
        Infix2PostfixConverterTest.class,
        PostfixExprEvaluatorTest.class,

})

public class MainTestSuite {
}
