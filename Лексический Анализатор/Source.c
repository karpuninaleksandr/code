#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <locale.h>

#define SizeofTables 256

struct Table
{
	char C[SizeofTables];
	struct Table* next;
} *TW, * TD, * TID;

struct TableforNums
{
	int num;
	struct TableforNums* next;
} *TNUM;

char buf[SizeofTables];
char c;
int d;

FILE* in;

void init()
{
	struct Table* tmp1;
	struct Table* tmp2;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	char lex1[] = "begin";
	int i = 0;
	for (i = 0; i < strlen(lex1); ++i)
	{
		tmp1->C[i] = lex1[i];
	}
	tmp1->C[i] = '\0';
	TW = tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex2[] = "end";
	for (i = 0; i < strlen(lex2); ++i)
	{
		tmp1->C[i] = lex2[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex[] = "for";
	for (i = 0; i < strlen(lex); ++i)
	{
		tmp1->C[i] = lex[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex0[] = "to";
	for (i = 0; i < strlen(lex0); ++i)
	{
		tmp1->C[i] = lex0[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex3[] = "downto";
	for (i = 0; i < strlen(lex3); ++i)
	{
		tmp1->C[i] = lex3[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex4[] = "next";
	for (i = 0; i < strlen(lex4); ++i)
	{
		tmp1->C[i] = lex4[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex5[] = "or";
	for (i = 0; i < strlen(lex5); ++i)
	{
		tmp1->C[i] = lex5[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex6[] = "and";
	for (i = 0; i < strlen(lex6); ++i)
	{
		tmp1->C[i] = lex6[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex7[] = "not";
	for (i = 0; i < strlen(lex7); ++i)
	{
		tmp1->C[i] = lex7[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp2->next = NULL;

	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	char lex8[] = ":=";
	for (i = 0; i < strlen(lex8); ++i)
	{
		tmp1->C[i] = lex8[i];
	}
	tmp1->C[i] = '\0';
	TD = tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex9[] = "=";
	for (i = 0; i < strlen(lex9); ++i)
	{
		tmp1->C[i] = lex9[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex10[] = "<";
	for (i = 0; i < strlen(lex10); ++i)
	{
		tmp1->C[i] = lex10[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex11[] = ">";
	for (i = 0; i < strlen(lex11); ++i)
	{
		tmp1->C[i] = lex11[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex12[] = "!=";
	for (i = 0; i < strlen(lex12); ++i)
	{
		tmp1->C[i] = lex12[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex13[] = "+";
	for (i = 0; i < strlen(lex13); ++i)
	{
		tmp1->C[i] = lex13[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex14[] = "-";
	for (i = 0; i < strlen(lex14); ++i)
	{
		tmp1->C[i] = lex14[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex15[] = "*";
	for (i = 0; i < strlen(lex15); ++i)
	{
		tmp1->C[i] = lex15[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex16[] = "/";
	for (i = 0; i < strlen(lex16); ++i)
	{
		tmp1->C[i] = lex16[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex17[] = "(";
	for (i = 0; i < strlen(lex17); ++i)
	{
		tmp1->C[i] = lex17[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex18[] = ")";
	for (i = 0; i < strlen(lex18); ++i)
	{
		tmp1->C[i] = lex18[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex19[] = ";";
	for (i = 0; i < strlen(lex19); ++i)
	{
		tmp1->C[i] = lex19[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp1 = (struct Table*)malloc(sizeof(struct Table));
	tmp2->next = tmp1;
	char lex20[] = "EOF";
	for (i = 0; i < strlen(lex20); ++i)
	{
		tmp1->C[i] = lex20[i];
	}
	tmp1->C[i] = '\0';
	tmp2 = tmp1;
	tmp2->next = NULL;

	TID = TNUM = NULL;
	d = 0;
}

void freeTables()
{
	struct Table* tmp;
	struct Table* curr;
	curr = TW;
	while (curr != NULL)
	{
		tmp = curr;
		curr = curr->next;
		free(tmp);
	}
	curr = TD;
	while (curr != NULL)
	{
		tmp = curr;
		curr = curr->next;
		free(tmp);
	}
	curr = TID;
	while (curr != NULL)
	{
		tmp = curr;
		curr = curr->next;
		free(tmp);
	}
	struct TableforNums* check;
	check = TNUM;
	while (check != NULL)
	{
		tmp = check;
		check = check->next;
		free(tmp);
	}

}

void clear()
{
	for (int i = 0; i < SizeofTables; ++i)
	{
		buf[i] = '\0';
	}
}

void add()
{
	int a = 0;
	int k = 0;
	while (buf[k] != '\0')
	{
		++a;
		++k;
	}
	buf[a] = c;
	buf[a + 1] = '\0';
}

int look(struct Table* T)
{
	struct Table* curr;
	int str = 0;
	int ans = 0;
	for (curr = T; curr != NULL; curr = curr->next)
	{
		++str;
		int length = 0;
		int k = 0;
		int a = 0;
		int b = 0;
		while (buf[k] != '\0')
		{
			++a;
			++k;
		}
		k = 0;
		while (curr->C[k] != '\0')
		{
			++b;
			++k;
		}
		k = 0;
		if (a == b)
		{
			//printf("A");
			for (int i = 0; i < b; ++i)
			{
				if (buf[i] == curr->C[i])
				{
					++length;
				}
			}
			if (a == length)
			{
				ans = str;
			}
		}
	}
	return ans;
}

int putl(struct Table* T)
{
	struct Table* curr;
	int str = look(TID);
	int ans = 1;
	if (str == 0)
	{
		struct Table* tmp = (struct Table*)malloc(sizeof(struct Table));
		if (TID != NULL)
		{
			for (curr = TID; curr->next != NULL; curr = curr->next)
			{
				++ans;
			}
			curr->next = tmp;
			tmp->next = NULL;
			curr = tmp;
			++ans;
		}
		else
		{
			TID = curr = tmp;
			tmp->next = NULL;
		}
		int i = 0;
		int a = 0;
		int k = 0;
		while (buf[k] != '\0')
		{
			++a;
			++k;
		}
		for (i = 0; i < a; ++i)
		{
			curr->C[i] = buf[i];
		}
		curr->C[i] = '\0';
	}
	else
	{
		ans = str;
	}
	clear();
	return ans;
}

int putnum()
{
	struct TableforNums* curr;
	struct TableforNums* tmp = (struct TableforNums*)malloc(sizeof(struct TableforNums));
	int str = 0;
	int ans = 1;
	if (TNUM == NULL)
	{
		TNUM = tmp;
		tmp->next = NULL;
		tmp->num = d;
		d = 0;
	}
	else
	{
		for (curr = TNUM; curr->next != NULL; curr = curr->next)
		{
			if (curr->num == d)
			{
				d = 0;
				return ans;
			}
			++ans;
		}
		++ans;
		curr->next = tmp;
		tmp->next = NULL;
		tmp->num = d;
		d = 0;
	}
	return ans;
}

void makelex(int k, int i)
{
	printf("<%d, %d>", k, i);
}

void gc()
{
	c = fgetc(in);
}

void printTable(struct Table* T)
{
	struct Table* curr;
	int j = 1;
	for (curr = T; curr != NULL; curr = curr->next)
	{
		printf("%d) ", j);
		int i = 0;
		while(curr->C[i] != '\0')
		{
			printf("%c", curr->C[i]);
			++i;
		}
		printf("\n");
		++j;
	}
}

void printTNUM()
{
	int j = 1;
	struct TableforNums* curr;
	for (curr = TNUM; curr != NULL; curr = curr->next)
	{
		printf("%d) %d\n", j, curr->num);
		++j;
	}
}

void main(int argc, char* argv[])
{
	init();
	setlocale(LC_ALL, "RUS");
	in = fopen(argv[1], "rt");
	if (in == NULL)
	{
		printf("\nОшибка!\nНевозможно открыть файл.\n");
		freeTables();
		return 1;
	}
	gc();
	while (c != EOF)
	{
		while (c == ' ')
		{
			gc();
		}
		while (c == '\n')
		{
			printf("\n");
			gc();
		}
		int tmp = (int)c;
		if (isalpha(c))
		{
			clear();
			int length = 1;
			while ((isalpha(c)) || (isdigit(c)))
			{
				add();
				gc();
				++length;
				if (length == 256)
				{
					printf("\nОшибка!\nДлина идентификатора не может быть больше 255 символов.\n");
					freeTables();
					fclose(in);
					return 1;
				}
			}
			int j = look(TW);
			int k = 0;
			if (j == 0)
			{
				j = putl(TID);
				makelex(3, j);
			}
			else
			{
				makelex(1, j);
			}
			clear();
		}
		else
		{
			if (isdigit(c))
			{
				clear();
				while (isdigit(c))
				{
					d = d * 10 + (c - '0');
					gc();
					if (d > 32767)
					{
						printf("\nОшибка!\nКонстанта не может принимать значения больше, чем 32767.\n");
						freeTables();
						fclose(in);
						return 1;

					}
				}
				if (isalpha(c))
				{
					printf("\nОшибка!\nНевозможное объявление константы.\n");
					freeTables();
					fclose(in);
					return 1;
				}
				int j = putnum();
				makelex(4, j);
			}
			else
			{
				if (c == ':')
				{
					gc();
					if (c == '=')
					{
						makelex(2, 1);
						gc();
					}
					else
					{
						printf("\nОшибка!\nЗнак <<:>>  не может быть распознан.\n");
						freeTables();
						fclose(in);
						return 1;
					}
				}
				else
				{
					if (c == '!')
					{
						gc();
						if (c == '=')
						{
							makelex(2, 5);
							gc();
						}
						else
						{
							printf("\nОшибка!\nЗнак <<!>>  не может быть распознан.\n");
							freeTables();
							fclose(in);
							return 1;
						}
					}
					else
					{
						if (c == '{')
						{
							while (c != '}')
							{
								gc();
								if (c == EOF)
								{
									printf("\nОшибка!\nПрограмма не может оканчиваться незавершенным комментарием.\n");
									freeTables();
									fclose(in);
									return 1;
								}
							}
							gc();
						}
						else
						{
							if (c == EOF)
							{
								makelex(2, 13);
								break;
							}
							else
							{
								clear();
								add();
								int j = look(TD);
								if (j == 0)
								{
									printf("\nОшибка!\nВстретился неопределяемый символ.\n");
									freeTables();
									fclose(in);
									return 1;
								}
								else
								{
									makelex(2, j);
									gc();
								}
							}
						}
					}
				}
			}
		}
	}
	if (c == EOF)
	{
		makelex(2, 13);
	}
	printf("\n\nЛексический анализ прошел успешно!\n");
	printf("\nТаблица TW:\n");
	printTable(TW);
	printf("\nТаблица TD:\n");
	printTable(TD);
	printf("\nТаблица TID:\n");
	printTable(TID);
	printf("\nТаблица TNUM:\n");
	printTNUM();
	freeTables();
	clear();
	fclose(in);
}