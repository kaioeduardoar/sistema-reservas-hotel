package model;

    public enum TipoQuarto {
        SOLTEIRO("Solteiro"),
        CASAL("Casal"),
        SUITE("Suíte"),
        LUXO("Luxo");

        private final String descricao;

        TipoQuarto(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }
