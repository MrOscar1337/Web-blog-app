PGDMP         7                {            Web_blog    15.2    15.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16544    Web_blog    DATABASE     ~   CREATE DATABASE "Web_blog" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Web_blog";
                postgres    false            �            1259    16546    posts    TABLE     �   CREATE TABLE public.posts (
    views integer NOT NULL,
    id bigint NOT NULL,
    anons character varying(255),
    text character varying(255),
    title character varying(255)
);
    DROP TABLE public.posts;
       public         heap    postgres    false            �            1259    16545 	   posts_seq    SEQUENCE     s   CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.posts_seq;
       public          postgres    false            �          0    16546    posts 
   TABLE DATA           >   COPY public.posts (views, id, anons, text, title) FROM stdin;
    public          postgres    false    215   Y       �           0    0 	   posts_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.posts_seq', 51, true);
          public          postgres    false    214            f           2606    16552    posts posts_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.posts DROP CONSTRAINT posts_pkey;
       public            postgres    false    215            �   Q   x�3�4��K-Wp,*�L�IUHL�/-QH����L-�t��
��
e�E�
)�9�ə���
�%
��9�
֚��Ț�b���� 0�S     