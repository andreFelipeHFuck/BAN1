PGDMP  2    
            
    {            loja_eletronicos     16.1 (Ubuntu 16.1-1.pgdg22.04+1)     16.1 (Ubuntu 16.1-1.pgdg22.04+1) ]    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25129    loja_eletronicos    DATABASE     |   CREATE DATABASE loja_eletronicos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
     DROP DATABASE loja_eletronicos;
                postgres    false            �            1259    25131    clientes    TABLE     �  CREATE TABLE public.clientes (
    codcliente integer NOT NULL,
    email character varying(50) NOT NULL,
    telefone character varying(15) NOT NULL,
    nome character varying(50) NOT NULL,
    rua character varying(50) NOT NULL,
    cep integer NOT NULL,
    bairro character varying(50) NOT NULL,
    tipo integer NOT NULL,
    datanascimento date,
    sexo character varying(20),
    cpf character varying(20),
    cnpj character varying(20)
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            �            1259    25130    clientes_codcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.clientes_codcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.clientes_codcliente_seq;
       public          postgres    false    216            �           0    0    clientes_codcliente_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.clientes_codcliente_seq OWNED BY public.clientes.codcliente;
          public          postgres    false    215            �            1259    25213    compra    TABLE     �   CREATE TABLE public.compra (
    codcompra integer NOT NULL,
    codfornecedor integer NOT NULL,
    codproduto integer NOT NULL,
    quantidade integer NOT NULL,
    codtransportadora integer NOT NULL,
    data date NOT NULL
);
    DROP TABLE public.compra;
       public         heap    postgres    false            �            1259    25209    compra_codcompra_seq    SEQUENCE     �   CREATE SEQUENCE public.compra_codcompra_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.compra_codcompra_seq;
       public          postgres    false    236            �           0    0    compra_codcompra_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.compra_codcompra_seq OWNED BY public.compra.codcompra;
          public          postgres    false    232            �            1259    25210    compra_codfornecedor_seq    SEQUENCE     �   CREATE SEQUENCE public.compra_codfornecedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.compra_codfornecedor_seq;
       public          postgres    false    236            �           0    0    compra_codfornecedor_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.compra_codfornecedor_seq OWNED BY public.compra.codfornecedor;
          public          postgres    false    233            �            1259    25211    compra_codproduto_seq    SEQUENCE     �   CREATE SEQUENCE public.compra_codproduto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.compra_codproduto_seq;
       public          postgres    false    236            �           0    0    compra_codproduto_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.compra_codproduto_seq OWNED BY public.compra.codproduto;
          public          postgres    false    234            �            1259    25212    compra_codtransportadora_seq    SEQUENCE     �   CREATE SEQUENCE public.compra_codtransportadora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.compra_codtransportadora_seq;
       public          postgres    false    236            �           0    0    compra_codtransportadora_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.compra_codtransportadora_seq OWNED BY public.compra.codtransportadora;
          public          postgres    false    235            �            1259    25168 
   fornecedor    TABLE     �   CREATE TABLE public.fornecedor (
    codfornecedor integer NOT NULL,
    nome character varying(50) NOT NULL,
    cnpj character varying(20) NOT NULL,
    email character varying(50) NOT NULL
);
    DROP TABLE public.fornecedor;
       public         heap    postgres    false            �            1259    25167    fornecedor_codfornecedor_seq    SEQUENCE     �   CREATE SEQUENCE public.fornecedor_codfornecedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.fornecedor_codfornecedor_seq;
       public          postgres    false    224            �           0    0    fornecedor_codfornecedor_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.fornecedor_codfornecedor_seq OWNED BY public.fornecedor.codfornecedor;
          public          postgres    false    223            �            1259    25149    kits    TABLE     �   CREATE TABLE public.kits (
    codkit integer NOT NULL,
    codkitproduto integer NOT NULL,
    codproduto integer NOT NULL,
    nome character varying(50),
    quantidadeproduto integer NOT NULL
);
    DROP TABLE public.kits;
       public         heap    postgres    false            �            1259    25146    kits_codkit_seq    SEQUENCE     �   CREATE SEQUENCE public.kits_codkit_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.kits_codkit_seq;
       public          postgres    false    222            �           0    0    kits_codkit_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.kits_codkit_seq OWNED BY public.kits.codkit;
          public          postgres    false    219            �            1259    25147    kits_codkitproduto_seq    SEQUENCE     �   CREATE SEQUENCE public.kits_codkitproduto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.kits_codkitproduto_seq;
       public          postgres    false    222            �           0    0    kits_codkitproduto_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.kits_codkitproduto_seq OWNED BY public.kits.codkitproduto;
          public          postgres    false    220            �            1259    25148    kits_codproduto_seq    SEQUENCE     �   CREATE SEQUENCE public.kits_codproduto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.kits_codproduto_seq;
       public          postgres    false    222            �           0    0    kits_codproduto_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.kits_codproduto_seq OWNED BY public.kits.codproduto;
          public          postgres    false    221            �            1259    25138    produtos    TABLE     6  CREATE TABLE public.produtos (
    codproduto integer NOT NULL,
    precounitvenda double precision NOT NULL,
    precounitcompra double precision NOT NULL,
    descricao character varying(200) NOT NULL,
    quantidade integer NOT NULL,
    nome character varying(50),
    datasheet character varying(1000)
);
    DROP TABLE public.produtos;
       public         heap    postgres    false            �            1259    25137    produtos_codproduto_seq    SEQUENCE     �   CREATE SEQUENCE public.produtos_codproduto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.produtos_codproduto_seq;
       public          postgres    false    218            �           0    0    produtos_codproduto_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.produtos_codproduto_seq OWNED BY public.produtos.codproduto;
          public          postgres    false    217            �            1259    25175    transportadora    TABLE     �   CREATE TABLE public.transportadora (
    codtransportadora integer NOT NULL,
    nome character varying(50) NOT NULL,
    cnpj character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    custokm double precision NOT NULL
);
 "   DROP TABLE public.transportadora;
       public         heap    postgres    false            �            1259    25174 $   transportadora_codtransportadora_seq    SEQUENCE     �   CREATE SEQUENCE public.transportadora_codtransportadora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.transportadora_codtransportadora_seq;
       public          postgres    false    226            �           0    0 $   transportadora_codtransportadora_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.transportadora_codtransportadora_seq OWNED BY public.transportadora.codtransportadora;
          public          postgres    false    225            �            1259    25185    venda    TABLE       CREATE TABLE public.venda (
    codvenda integer NOT NULL,
    codcliente integer NOT NULL,
    codproduto integer NOT NULL,
    quantidade integer NOT NULL,
    formapagamento character varying(50) NOT NULL,
    codtransportadora integer NOT NULL,
    data date NOT NULL
);
    DROP TABLE public.venda;
       public         heap    postgres    false            �            1259    25182    venda_codcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_codcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.venda_codcliente_seq;
       public          postgres    false    231            �           0    0    venda_codcliente_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.venda_codcliente_seq OWNED BY public.venda.codcliente;
          public          postgres    false    228            �            1259    25183    venda_codproduto_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_codproduto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.venda_codproduto_seq;
       public          postgres    false    231            �           0    0    venda_codproduto_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.venda_codproduto_seq OWNED BY public.venda.codproduto;
          public          postgres    false    229            �            1259    25184    venda_codtransportadora_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_codtransportadora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.venda_codtransportadora_seq;
       public          postgres    false    231            �           0    0    venda_codtransportadora_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.venda_codtransportadora_seq OWNED BY public.venda.codtransportadora;
          public          postgres    false    230            �            1259    25181    venda_codvenda_seq    SEQUENCE     �   CREATE SEQUENCE public.venda_codvenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.venda_codvenda_seq;
       public          postgres    false    231            �           0    0    venda_codvenda_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.venda_codvenda_seq OWNED BY public.venda.codvenda;
          public          postgres    false    227            �           2604    25134    clientes codcliente    DEFAULT     z   ALTER TABLE ONLY public.clientes ALTER COLUMN codcliente SET DEFAULT nextval('public.clientes_codcliente_seq'::regclass);
 B   ALTER TABLE public.clientes ALTER COLUMN codcliente DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    25216    compra codcompra    DEFAULT     t   ALTER TABLE ONLY public.compra ALTER COLUMN codcompra SET DEFAULT nextval('public.compra_codcompra_seq'::regclass);
 ?   ALTER TABLE public.compra ALTER COLUMN codcompra DROP DEFAULT;
       public          postgres    false    236    232    236            �           2604    25217    compra codfornecedor    DEFAULT     |   ALTER TABLE ONLY public.compra ALTER COLUMN codfornecedor SET DEFAULT nextval('public.compra_codfornecedor_seq'::regclass);
 C   ALTER TABLE public.compra ALTER COLUMN codfornecedor DROP DEFAULT;
       public          postgres    false    236    233    236            �           2604    25218    compra codproduto    DEFAULT     v   ALTER TABLE ONLY public.compra ALTER COLUMN codproduto SET DEFAULT nextval('public.compra_codproduto_seq'::regclass);
 @   ALTER TABLE public.compra ALTER COLUMN codproduto DROP DEFAULT;
       public          postgres    false    236    234    236            �           2604    25219    compra codtransportadora    DEFAULT     �   ALTER TABLE ONLY public.compra ALTER COLUMN codtransportadora SET DEFAULT nextval('public.compra_codtransportadora_seq'::regclass);
 G   ALTER TABLE public.compra ALTER COLUMN codtransportadora DROP DEFAULT;
       public          postgres    false    236    235    236            �           2604    25171    fornecedor codfornecedor    DEFAULT     �   ALTER TABLE ONLY public.fornecedor ALTER COLUMN codfornecedor SET DEFAULT nextval('public.fornecedor_codfornecedor_seq'::regclass);
 G   ALTER TABLE public.fornecedor ALTER COLUMN codfornecedor DROP DEFAULT;
       public          postgres    false    223    224    224            �           2604    25152    kits codkit    DEFAULT     j   ALTER TABLE ONLY public.kits ALTER COLUMN codkit SET DEFAULT nextval('public.kits_codkit_seq'::regclass);
 :   ALTER TABLE public.kits ALTER COLUMN codkit DROP DEFAULT;
       public          postgres    false    219    222    222            �           2604    25153    kits codkitproduto    DEFAULT     x   ALTER TABLE ONLY public.kits ALTER COLUMN codkitproduto SET DEFAULT nextval('public.kits_codkitproduto_seq'::regclass);
 A   ALTER TABLE public.kits ALTER COLUMN codkitproduto DROP DEFAULT;
       public          postgres    false    220    222    222            �           2604    25154    kits codproduto    DEFAULT     r   ALTER TABLE ONLY public.kits ALTER COLUMN codproduto SET DEFAULT nextval('public.kits_codproduto_seq'::regclass);
 >   ALTER TABLE public.kits ALTER COLUMN codproduto DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    25141    produtos codproduto    DEFAULT     z   ALTER TABLE ONLY public.produtos ALTER COLUMN codproduto SET DEFAULT nextval('public.produtos_codproduto_seq'::regclass);
 B   ALTER TABLE public.produtos ALTER COLUMN codproduto DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    25178     transportadora codtransportadora    DEFAULT     �   ALTER TABLE ONLY public.transportadora ALTER COLUMN codtransportadora SET DEFAULT nextval('public.transportadora_codtransportadora_seq'::regclass);
 O   ALTER TABLE public.transportadora ALTER COLUMN codtransportadora DROP DEFAULT;
       public          postgres    false    226    225    226            �           2604    25188    venda codvenda    DEFAULT     p   ALTER TABLE ONLY public.venda ALTER COLUMN codvenda SET DEFAULT nextval('public.venda_codvenda_seq'::regclass);
 =   ALTER TABLE public.venda ALTER COLUMN codvenda DROP DEFAULT;
       public          postgres    false    227    231    231            �           2604    25189    venda codcliente    DEFAULT     t   ALTER TABLE ONLY public.venda ALTER COLUMN codcliente SET DEFAULT nextval('public.venda_codcliente_seq'::regclass);
 ?   ALTER TABLE public.venda ALTER COLUMN codcliente DROP DEFAULT;
       public          postgres    false    231    228    231            �           2604    25190    venda codproduto    DEFAULT     t   ALTER TABLE ONLY public.venda ALTER COLUMN codproduto SET DEFAULT nextval('public.venda_codproduto_seq'::regclass);
 ?   ALTER TABLE public.venda ALTER COLUMN codproduto DROP DEFAULT;
       public          postgres    false    229    231    231            �           2604    25191    venda codtransportadora    DEFAULT     �   ALTER TABLE ONLY public.venda ALTER COLUMN codtransportadora SET DEFAULT nextval('public.venda_codtransportadora_seq'::regclass);
 F   ALTER TABLE public.venda ALTER COLUMN codtransportadora DROP DEFAULT;
       public          postgres    false    230    231    231            o          0    25131    clientes 
   TABLE DATA           ~   COPY public.clientes (codcliente, email, telefone, nome, rua, cep, bairro, tipo, datanascimento, sexo, cpf, cnpj) FROM stdin;
    public          postgres    false    216   ?o       �          0    25213    compra 
   TABLE DATA           k   COPY public.compra (codcompra, codfornecedor, codproduto, quantidade, codtransportadora, data) FROM stdin;
    public          postgres    false    236   )q       w          0    25168 
   fornecedor 
   TABLE DATA           F   COPY public.fornecedor (codfornecedor, nome, cnpj, email) FROM stdin;
    public          postgres    false    224   xq       u          0    25149    kits 
   TABLE DATA           Z   COPY public.kits (codkit, codkitproduto, codproduto, nome, quantidadeproduto) FROM stdin;
    public          postgres    false    222   �q       q          0    25138    produtos 
   TABLE DATA           w   COPY public.produtos (codproduto, precounitvenda, precounitcompra, descricao, quantidade, nome, datasheet) FROM stdin;
    public          postgres    false    218   3r       y          0    25175    transportadora 
   TABLE DATA           W   COPY public.transportadora (codtransportadora, nome, cnpj, email, custokm) FROM stdin;
    public          postgres    false    226   �u       ~          0    25185    venda 
   TABLE DATA           v   COPY public.venda (codvenda, codcliente, codproduto, quantidade, formapagamento, codtransportadora, data) FROM stdin;
    public          postgres    false    231   �u       �           0    0    clientes_codcliente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.clientes_codcliente_seq', 10, true);
          public          postgres    false    215            �           0    0    compra_codcompra_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.compra_codcompra_seq', 4, true);
          public          postgres    false    232            �           0    0    compra_codfornecedor_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.compra_codfornecedor_seq', 1, false);
          public          postgres    false    233            �           0    0    compra_codproduto_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.compra_codproduto_seq', 1, false);
          public          postgres    false    234            �           0    0    compra_codtransportadora_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.compra_codtransportadora_seq', 1, false);
          public          postgres    false    235            �           0    0    fornecedor_codfornecedor_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.fornecedor_codfornecedor_seq', 4, true);
          public          postgres    false    223            �           0    0    kits_codkit_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.kits_codkit_seq', 6, true);
          public          postgres    false    219            �           0    0    kits_codkitproduto_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.kits_codkitproduto_seq', 1, false);
          public          postgres    false    220            �           0    0    kits_codproduto_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.kits_codproduto_seq', 1, false);
          public          postgres    false    221            �           0    0    produtos_codproduto_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.produtos_codproduto_seq', 8, true);
          public          postgres    false    217            �           0    0 $   transportadora_codtransportadora_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.transportadora_codtransportadora_seq', 4, true);
          public          postgres    false    225            �           0    0    venda_codcliente_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.venda_codcliente_seq', 1, false);
          public          postgres    false    228            �           0    0    venda_codproduto_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.venda_codproduto_seq', 1, false);
          public          postgres    false    229            �           0    0    venda_codtransportadora_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.venda_codtransportadora_seq', 1, false);
          public          postgres    false    230            �           0    0    venda_codvenda_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.venda_codvenda_seq', 9, true);
          public          postgres    false    227            �           2606    25136    clientes clientes_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (codcliente);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public            postgres    false    216            �           2606    25221    compra compra_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (codcompra);
 <   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_pkey;
       public            postgres    false    236            �           2606    25173    fornecedor fornecedor_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (codfornecedor);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public            postgres    false    224            �           2606    25156    kits kits_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.kits
    ADD CONSTRAINT kits_pkey PRIMARY KEY (codkit);
 8   ALTER TABLE ONLY public.kits DROP CONSTRAINT kits_pkey;
       public            postgres    false    222            �           2606    25145    produtos produtos_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (codproduto);
 @   ALTER TABLE ONLY public.produtos DROP CONSTRAINT produtos_pkey;
       public            postgres    false    218            �           2606    25180 "   transportadora transportadora_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.transportadora
    ADD CONSTRAINT transportadora_pkey PRIMARY KEY (codtransportadora);
 L   ALTER TABLE ONLY public.transportadora DROP CONSTRAINT transportadora_pkey;
       public            postgres    false    226            �           2606    25193    venda venda_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (codvenda);
 :   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_pkey;
       public            postgres    false    231            �           2606    25222     compra compra_codfornecedor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_codfornecedor_fkey FOREIGN KEY (codfornecedor) REFERENCES public.fornecedor(codfornecedor);
 J   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_codfornecedor_fkey;
       public          postgres    false    3280    236    224            �           2606    25227    compra compra_codproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_codproduto_fkey FOREIGN KEY (codproduto) REFERENCES public.produtos(codproduto);
 G   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_codproduto_fkey;
       public          postgres    false    218    3276    236            �           2606    25232 $   compra compra_codtransportadora_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_codtransportadora_fkey FOREIGN KEY (codtransportadora) REFERENCES public.transportadora(codtransportadora);
 N   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_codtransportadora_fkey;
       public          postgres    false    3282    226    236            �           2606    25162    kits kits_codkitproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.kits
    ADD CONSTRAINT kits_codkitproduto_fkey FOREIGN KEY (codkitproduto) REFERENCES public.produtos(codproduto);
 F   ALTER TABLE ONLY public.kits DROP CONSTRAINT kits_codkitproduto_fkey;
       public          postgres    false    3276    222    218            �           2606    25157    kits kits_codproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.kits
    ADD CONSTRAINT kits_codproduto_fkey FOREIGN KEY (codproduto) REFERENCES public.produtos(codproduto);
 C   ALTER TABLE ONLY public.kits DROP CONSTRAINT kits_codproduto_fkey;
       public          postgres    false    3276    218    222            �           2606    25194    venda venda_codcliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_codcliente_fkey FOREIGN KEY (codcliente) REFERENCES public.clientes(codcliente);
 E   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_codcliente_fkey;
       public          postgres    false    231    216    3274            �           2606    25199    venda venda_codproduto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_codproduto_fkey FOREIGN KEY (codproduto) REFERENCES public.produtos(codproduto);
 E   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_codproduto_fkey;
       public          postgres    false    218    3276    231            �           2606    25204 "   venda venda_codtransportadora_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_codtransportadora_fkey FOREIGN KEY (codtransportadora) REFERENCES public.transportadora(codtransportadora);
 L   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_codtransportadora_fkey;
       public          postgres    false    3282    231    226            o   �  x�}�Mn�@���)�X]͟م�=�X�d�HYyS�Vh���u��r��X��A��X����WԖZ~�U�M��4MQ�9vͫ�T*8<�s�u�7� 8G��>�aO���Uӱ���WO��"���'�6�5��>�@��JK���|��W����+H'�d�#��\��K�/leS�� p0«,�
�R:8�;P_�y��D�s��k&p0�,�j��$���	p�ړ��i�Ϳ۔L��D� `�p�&v5.+�A��P�څ3�[��j��ɶ*������x�q��Fֶ���v��"~@y	Pi��
�D���,��w��_��R�c__�6�K �3$z�0�Z��(�|�X�w������b�]���ށخ-{��j�{b�LA�m��J�t��Wv�'w@�R�i���j]b��q���\,6&�2�ڣ�{v7�tɬ�FA8�-���b��ܓ>���6��m��o<����*�      �   ?   x�M���0�jq�D=�2��.|9TH��0ᑃ1�Şe�J��R���2P�}ʕ�`z8�      w   X   x�3�t�/�KMNM�/2�4�CC�4��Cjnbf�^r~.��#�CT-FHZ���s"�G��I�	�w!i1qH������ +=z      u   C   x�3�4�4���4�2�4�1�9M LS.NSӈ˔����͂�;�D!(?)_���$(���� ?r      q   B  x�mTMo�F=�~�ħ�(R��-p�C�6F ��ˊI�p9��Rm�kd�P�@O�/��MyKQ�D�j�3��7��i:M.�$K��zC�L��hL%���nH�x�*̞�O��Z*�{�Kt��Z;MB���>0�}�.a{O�`]�n�ް��LՎs�xY;F��2wE�ڔ&hҔ;�ۿۿ�
�}{�L,��=���$M�W��.��?�Q%pSH�%'[8Ac���z�Oa#�u9!�4��sB4�XMu��ވë�\�v��C9�I�� W�_����D�"�=W`ko,����3��JSi�m�� �jH�غ4��H��Mn��}��2�ё�D��� ���t��B7~}��c�a]��+
��ײq�G���x<��lY��J��MČ6������p��'��~<\;	��R@�����5���x��� i�"����p"?�$:u4��Y[� �hY��L�t3�Ioa�B����~����i'�;wO�Z���B�z��`��q|d�54�(m6���-�;��J�?;� n�&�\e�ZW�il$�^����,}���ʢ2�����I���x��c�u	�l;Wt�E�l���݋J�ߕ��~A���q1�R��_Ⳙ/��d�P��>��x��̏l��dx�'�|�Fn\ޘ/�Y9�4����4����!mڻܔq0p`�S�.��c5�"'�� i��t-]c�4X%���tu���fӕʖ3���������CX0ʝ���qt�n�MW��� d`C(j��m�K��s)u�ڸ�BΧ���;V��Kꑔn[��~>s"O���!67��GLQ�w�`0�m���      y   j   x�uα
�0�9����i�͏pt)� X+��GAR���a,��\��������aMq�͜�a�������V�]�0�ם����S�Es�/�$A<N Q�      ~   s   x�m�;
�0�Zs},�{��)��b�9�B0r1���$q�����ZIR`e������5��%��2�JΟ��PP3	�iC�n|�D�|��R�����}�sp BL+�     