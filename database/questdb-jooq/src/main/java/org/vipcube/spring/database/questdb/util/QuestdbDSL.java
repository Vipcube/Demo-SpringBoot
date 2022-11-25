package org.vipcube.spring.database.questdb.util;

import org.jooq.Context;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.impl.CustomField;

import static org.jooq.impl.DSL.systemName;

public class QuestdbDSL {
    private QuestdbDSL() {
    }

    public static <T> Field<T> last(Field<T> field) {
        return new Last<>(field);
    }

    private static final class Last<T> extends CustomField<T> {
        public static final Name NAME = systemName("last");
        private final Field<T> field;

        public Last(Field<T> field) {
            super("last", field.getDataType().null_());

            this.field = field;
        }

        @Override
        public void accept(Context<?> ctx) {
            ctx.visit(NAME).sql('(').visit(field).sql(')');
        }
    }
}
